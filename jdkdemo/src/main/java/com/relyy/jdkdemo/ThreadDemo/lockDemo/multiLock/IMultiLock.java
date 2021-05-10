package com.relyy.jdkdemo.ThreadDemo.lockDemo.multiLock;

import java.util.List;

/**
 * @Description
 *  将多个ILock预提交之后
 *  再将IMultiLock当成一把锁使用即可
 * @Created by cairuirui
 * @Date 2021/5/6
 */
public interface IMultiLock {

	boolean preRLock(ILock lock);
	boolean preWLock(ILock lock);

	boolean preRLocks(List<ILock> lock);
	boolean preWLocks(List<ILock> lock);


}
