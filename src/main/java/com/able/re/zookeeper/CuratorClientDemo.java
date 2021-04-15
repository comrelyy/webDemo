package com.able.re.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.ibatis.annotations.Param;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.data.Stat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Description zookeeper客户端工具 Apache Curator
 * @Created by cairuirui
 * @Date 2020/11/21
 */
@Slf4j
public class CuratorClientDemo {

	public static void main(String[] args) {
		String zkAddress = "192.168.21.189:2181";

		//连不上zookeeper集群的重试策略
		ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
		//创建Curator客户端并启动
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, retry);
		client.start();
		//客户端与zookeeper服务端的链接状态监听
		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			@Override
			public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
				switch (connectionState){
					case CONNECTED:
						//第一次成功链接到zookeeper会进入该状态
						//对于每一个CuratorFramework对象，该状态仅出现一次
						break;
					case SUSPENDED:
						//链接丢失
						break;
					case RECONNECTED:
						//丢失的链接重新建立
						break;
					case LOST:
						//当Curator认为会话已过期时，则进入此状态
						break;
					case READ_ONLY:
						//连接进入只读模式
						break;
				}
			}
		});

		//create and delete
		try{
			//createAndDelete(client);
			backgroundCallback(client);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			client.close();
		}


	}

	private static void backgroundCallback(CuratorFramework client) throws Exception{
		client.getCuratorListenable().addListener(new CuratorListener() {
			@Override
			public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
				switch (curatorEvent.getType()){
					case CREATE:
						log.info("CREATE:[{}]",curatorEvent.getPath());
						break;
					case DELETE:
						log.info("DELETE:[{}]",curatorEvent.getPath());
						break;
					case EXISTS:
						log.info("EXISTS:[{}]",curatorEvent.getPath());
						break;
					case GET_DATA:
						log.info("GET_DATA:[{}]",curatorEvent.getPath());
						break;
					case SET_DATA:
						log.info("SET_DATA:[{}]",curatorEvent.getPath());
						break;
					case CHILDREN:
						log.info("CHILDREN:[{}]",curatorEvent.getPath());
						break;
					default:
						break;
				}
			}
		});

		client.create().withMode(CreateMode.PERSISTENT)
				.inBackground().forPath("/user","test".getBytes());
		client.checkExists().inBackground().forPath("/user");
		client.setData().inBackground().forPath("/user","setData-Test".getBytes());
		client.getData().inBackground().forPath("/user");
		for (int i = 0; i < 3; i++){
			client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
					.inBackground().forPath("/user/child-"+i);
		}
		client.getChildren().inBackground().forPath("/user");
		//
		client.getChildren().inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
				log.info("in background:[{}],[{}]",curatorEvent.getType(),curatorEvent.getPath());
			}
		}).forPath("/user");
		client.delete().deletingChildrenIfNeeded().inBackground().forPath("/user");
		//System.in.read();
	}

	/**
	 * 同步的基本操作
	 * @param client
	 * @throws Exception
	 */
	private static void createAndDelete(CuratorFramework client) throws Exception{
		String path = client.create().withMode(CreateMode.PERSISTENT)
				.forPath("/reTest", "test".getBytes());
		//String path = "/reTest";
		log.info("path:[{}]",path);

		Stat stat = client.checkExists().forPath(path);
		log.info("stat:[{}]",stat);

		byte[] data = client.getData().forPath("/reTest");
		log.info("reTest data:[{}]",new String(data));

		for (int i = 0; i < 3; i++) {
			client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
					.forPath("/reTest/child-"+i);
		}
		List<String> children = client.getChildren().forPath("/reTest");

		//添加一个watcher,usingWatcher() 方法添加的 CuratorWatcher 只会触发一次
		//如果需要持续监听就需要反复注册watcher
		/*
		Apache Curator 引入了 Cache 来实现对 ZooKeeper 服务端事件的监听。
		Cache 是 Curator 中对事件监听的包装，其对事件的监听其实可以近似看作是一个本地缓存视图和远程ZooKeeper 视图的对比过程。
		同时，Curator 能够自动为开发人员处理反复注册监听，从而大大简化了代码的复杂程度
		实践中常用的 Cache 有三大类：
		NodeCache。 对一个节点进行监听，监听事件包括指定节点的增删改操作。
					注意哦，NodeCache 不仅可以监听数据节点的内容变更，也能监听指定节点是否存在，
					如果原本节点不存在，那么 Cache 就会在节点被创建后触发 NodeCacheListener，删除操作亦然。
		PathChildrenCache。 对指定节点的一级子节点进行监听，监听事件包括子节点的增删改操作，但是不对该节点的操作监听。
		TreeCache。 综合 NodeCache 和 PathChildrenCache 的功能，是对指定节点以及其子节点进行监听，同时还可以设置监听的深度。
		 */
		client.getChildren().usingWatcher(new CuratorWatcher() {
			@Override
			public void process(WatchedEvent watchedEvent) throws Exception {
					log.info("get another add children node,event type:[{}],path:[{}]",watchedEvent.getType(),watchedEvent.getPath());
			}
		}).forPath("/reTest");
		log.info("reTest children:[{}]",children);
		client.delete().deletingChildrenIfNeeded().forPath("/reTest");
	}

	public static void createCacheWatcher(CuratorFramework client) throws Exception{
			// 创建NodeCache，监听的是"/reTest"这个节点
		NodeCache nodeCache = new NodeCache(client, "/reTest");
		/*
			start()方法有个boolean类型的参数，默认是false。如果设置为true，
            那么NodeCache在第一次启动的时候就会立刻从ZooKeeper上读取对应节点的
            数据内容，并保存在Cache中。
		*/
		nodeCache.start(true);
		if (nodeCache.getCurrentData() != null) {
			log.info("nodeCache 节点初始化数据为:[{}]",String.valueOf(nodeCache.getCurrentData().getData()));
		}else {
			log.warn("nodeCache 初始化数据为空");
		}

		//添加监听器
		nodeCache.getListenable().addListener(() ->{
			String data = String.valueOf(nodeCache.getCurrentData().getData());
			log.info("nodeCache 节点路径:[{}],数据为:[{}]",nodeCache.getCurrentData().getPath(),data);
		});

		// 创建PathChildrenCache示例，监听"/reTest"节点
		PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/reTest", true);
		/*
		// StartMode指定的初始化的模式
        // NORMAL:普通异步初始化
        // BUILD_INITIAL_CACHE:同步初始化
        // POST_INITIALIZED_EVENT:异步初始化，初始化之后会触发事件
		 */
		pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
		List<ChildData> childDataList = pathChildrenCache.getCurrentData();
		//如果是BUILD_INITIAL_CACHE 才能获取数据
		childDataList.forEach(childData -> log.info("child data:[{}]",childData.getData()));
		pathChildrenCache.getListenable().addListener(((client1,event) -> {
			log.info("time:[{}],eventType:[{}]", LocalDateTime.now(),event.getType());
			if (Objects.equals(event.getType(), PathChildrenCacheEvent.Type.INITIALIZED)) {
				log.info("PathChildrenCache:子节点初始化成功...");
			}else if (Objects.equals(event.getType(), PathChildrenCacheEvent.Type.CHILD_ADDED)){
				//String path = event.getData().getPath();
				log.info("PathChildrenCache添加子节点:[{}]" ,event.getData().getPath());
				log.info("PathChildrenCache子节点数据:[{}]", new String(event.getData().getData()));
			}else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)){
				log.info("PathChildrenCache删除子节点:[{}]",event.getData().getPath());
			}else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
				log.info("PathChildrenCache修改子节点路径:[{}]" ,event.getData().getPath());
                log.info("PathChildrenCache修改子节点数据:[{}]",new String(event.getData().getData()));
			}
		}));

		TreeCache treeCache = TreeCache.newBuilder(client, "/reTest").setCacheData(false).build();
		treeCache.getListenable().addListener((c,event) -> {
			if (event.getData() != null) {
				log.info("TreeCache,type:[{}],path:[{}]",event.getType(),event.getData().getPath());
			}else {
				log.info("TreeCache,type:[{}]",event.getType());
			}
		});
		treeCache.start();


	}



}
