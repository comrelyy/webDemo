package com.relyy.other.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import javax.xml.ws.Service;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/9/26
 */
public class CuratorDemo {

	private static final String PATH = "/example/basic";

	public static void main(String[] args) throws Exception{
		TestingServer server = new TestingServer();
		CuratorFramework client = null;
		try{
			client = createSimple(server.getConnectString());
			client.start();
			client.create().creatingParentsIfNeeded().forPath(PATH,"test".getBytes());
			CloseableUtils.closeQuietly(client);

			client = creatWithOptions(server.getConnectString(),new ExponentialBackoffRetry(1000,3),1000,1000);
			client.start();
			System.out.println(new String(client.getData().forPath(PATH)));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseableUtils.closeQuietly(client);
			CloseableUtils.closeQuietly(server);
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
