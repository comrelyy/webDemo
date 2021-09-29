package com.relyy.other.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import javax.xml.ws.Service;
import java.util.List;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/9/26
 */
public class CuratorDemo {
	private static final String ROOTPATH = "/example";
	private static final String PATH = "/example/basic";
	private static final String CONNECT = "101.35.124.40:2181";

	public static void main(String[] args) throws Exception{
		//TestingServer server = new TestingServer();
		CuratorFramework client = null;
		try{
			client = createSimple(CONNECT);
			//会阻塞直到会话创建成功
			client.start();

			System.out.println(new String(client.getData().forPath(PATH)));
			client.create().creatingParentsIfNeeded().forPath("/example/basic2","test3".getBytes());
			//更新节点值
			//client.setData().forPath(PATH,"test1".getBytes());
			CloseableUtils.closeQuietly(client);

			client = creatWithOptions(CONNECT,new ExponentialBackoffRetry(1000,3),1000,1000);
			client.start();
			System.out.println(new String(client.getData().forPath(PATH)));
			//获取所有子节点
			List<String> strings = client.getChildren().forPath("ROOTPATH");
			strings.stream().forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseableUtils.closeQuietly(client);
			//CloseableUtils.closeQuietly(server);
		}
	}

	private static CuratorFramework creatWithOptions(String connectString, RetryPolicy retryPolicy, int connectionTimeoutMs, int sessionTimeoutMs) {
		return CuratorFrameworkFactory.builder().connectString(connectString)
				.retryPolicy(retryPolicy)
				.connectionTimeoutMs(connectionTimeoutMs)
				.sessionTimeoutMs(sessionTimeoutMs)
				.build();
	}

	private static CuratorFramework createSimple(String connectString) {

		ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
		return CuratorFrameworkFactory.newClient(connectString,retry);
	}
}
