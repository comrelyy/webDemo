package com.able.re.springResource.bean.collectionInject;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Description bean 的集合属性注入
 * @Created by cairuirui
 * @Date 2020/6/8
 */
@Data
public class CollectionsInjectionDemo {
	private List<String> listName;

	private Set<String> setName;

	private Properties propertiesName;

	private Map<String,String> mapName;

	private String[] arrayNames;


}
