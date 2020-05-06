package com.able.re.springResource.resource;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @Description 自定义协议解析器
 * @Created by cairuirui
 * @Date 2020/5/6
 */
public class MyProtocalResolover implements ProtocolResolver {
	@Override
	public Resource resolve(String location, ResourceLoader resourceLoader) {
		if (location.startsWith("my")) {
			return resourceLoader.getResource(location.replace("my","classpath"));
		}
		return null;
	}
}
