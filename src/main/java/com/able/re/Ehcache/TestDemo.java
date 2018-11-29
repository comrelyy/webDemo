package com.able.re.Ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/22
 */
public class TestDemo {
    public static void main(String[] args) {

        //创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
        //获取缓存对象
        Cache helloWorldCache = cacheManager.getCache("HelloWorldCache");

        //创建元素
        Element element = new Element("mykey", "myValue");

        //将元素添加到缓存
        helloWorldCache.put(element);

        //获取缓存
        Element value = helloWorldCache.get("mykey");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        //删除元素
        helloWorldCache.remove("mykey");

        System.out.println(helloWorldCache.getSize());

    }
}
