package com.relyy.jdkdemo.Demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-07
 */
public class ReferenceDemo {

    public static void main(String[] args) {
        Object obj = new Object();
        //测试软引用
        SoftReference<Object>  sf = new SoftReference<Object>(obj);
        //弱引用
        WeakReference<Object>  wf = new WeakReference<Object>(obj);
        //虚引用
        PhantomReference<Object> pf = new PhantomReference<Object>(obj,null);
        obj = null;
        System.out.println(sf.get() == null ? true : false);
        System.out.println(wf.get() == null ? true : false);
        System.out.println(pf.get() == null ? true : false);

        wf.isEnqueued();//返回对象是否被标记为即将回收的垃圾
        pf.isEnqueued();//是否对象已经从内存中删除
    }
}
