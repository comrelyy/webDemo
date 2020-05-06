package com.relyy.spring;

import com.relyy.TestBaseService;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/5/6
 */
public class ResourceTest{
	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource("spring/spring-bean.xml");
		//print(resource);
	}



	@Test
	public void test2() {
		ClassPathResource classPathResource = new ClassPathResource("spring/spring-bean.xml", ResourceTest.class);
		//class.getClassLoader().getResourceAsStream 默认是从classPath根目录下获取资源，不能以“/”开头
		InputStream resourceAsStream = ResourceTest.class.getClassLoader().getResourceAsStream("spring/spring-bean.xml");
		print(resourceAsStream);
		URL url_resource = ResourceTest.class.getResource("/spring/spring-bean.xml");
		try {
			System.out.println(url_resource.getContent());
			System.out.println(url_resource.getFile());
			InputStream inputStream = url_resource.openStream();
			System.out.println(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Class<?>.getResourceAsStream中要以"/"开头则表示从classPath根下获取资源，不是以“/”开头则是在此类所在的包下获取资源
		InputStream class_resourceAsStream = ResourceTest.class.getResourceAsStream("/spring/spring-bean.xml");
		print(class_resourceAsStream);

		InputStream package_resourceAsStream = ResourceTest.class.getResourceAsStream("xml/spring-package.xml");
		print(package_resourceAsStream);
	}

	@Test
	public void test3() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:spring/spring-bean.xml");
		try {
			InputStream inputStream = resource.getInputStream();
			print(inputStream);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void print(InputStream resourceAsStream) {
		byte[] read = new byte[10000];
		try {
			//resource.getInputStream().read(read,0,read.length);
			resourceAsStream.read(read,0,read.length);
			System.out.println(new String(read));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				resourceAsStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
