package com.able.re.designMode.prototype;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

/**
 * @Description 获取关键字及关键字搜索次数(原型模式)
 * @Created by cairuirui
 * @Date 2020/6/17
 */
public class SearchWordsDemo {
	private static final SearchWordsDemo instance = new SearchWordsDemo();

	private HashMap<String,SearchWord> keywordMap = new HashMap<>();

	private Long lastUpdateTime = -1L;

	private SearchWordsDemo(){}

	public static SearchWordsDemo getInstance(){
		return instance;
	}

	/**
	 * 数据在更新过程中会导致查询的数据版本不一致
	 */
	public void refreshV0(){
		List<SearchWord> modifyWords = getLastModifyData(lastUpdateTime);
		Long maxtime = lastUpdateTime;
		for (SearchWord modifyWord : modifyWords) {
			if (modifyWord.getLastUpdateTime() > lastUpdateTime){
				maxtime = modifyWord.getLastUpdateTime();
			}
			if (keywordMap.containsKey(modifyWord.getKeyword())){
				SearchWord searchWord = keywordMap.get(modifyWord.getKeyword());
				searchWord.setCount(modifyWord.getCount());
				searchWord.setLastUpdateTime(modifyWord.getLastUpdateTime());
			}else {
				keywordMap.put(modifyWord.getKeyword(),modifyWord);
			}
		}
		lastUpdateTime = maxtime;
	}

	/**
	*中间可以有个版本是每次获取数据库中的全量数据更新，这个再数据量大的时候
	* 数据库查询就是一个瓶颈，该方案直接略过
	*/

	/**
	 * 将正在使用的数据复制出一个副本，增删改操作都基于这个副本进行，结束之后在统一更新数据
	 * clone()方法再通常来说是浅克隆，只是复制了对象的引用，而不是正在的复制了一个对象，
	 * 即对象的地址值没有变化
	 */
	public void refreshV1(){
		HashMap<String, SearchWord> currentMap = (HashMap<String,SearchWord>)keywordMap.clone();
		List<SearchWord> modifyWords = getLastModifyData(lastUpdateTime);
		Long maxtime = lastUpdateTime;
		for (SearchWord modifyWord : modifyWords) {
			if (modifyWord.getLastUpdateTime() > lastUpdateTime){
				maxtime = modifyWord.getLastUpdateTime();
			}
			if (currentMap.containsKey(modifyWord.getKeyword())){
				SearchWord searchWord = currentMap.get(modifyWord.getKeyword());
				searchWord.setCount(modifyWord.getCount());
				searchWord.setLastUpdateTime(modifyWord.getLastUpdateTime());
			}else {
				currentMap.put(modifyWord.getKeyword(),modifyWord);
			}
		}
		lastUpdateTime = maxtime;
		keywordMap = currentMap;
	}

	/**
	 * 深克隆：一种是创建新对象，一种是通过序列化和反序列化，
	 * keywordMap中数据量大的时候深克隆会很影响性能，且不需要更新的数据是占多数的
	 * @param
	 * @return
	 */
	public void refreshV3(){
		HashMap<String, SearchWord> currentMap = new HashMap<>();
		keywordMap.forEach((key,value) -> {
			currentMap.put(key,new SearchWord(value.getKeyword(),value.getCount(),value.getLastUpdateTime()));
		});

		List<SearchWord> modifyWords = getLastModifyData(lastUpdateTime);
		Long maxtime = lastUpdateTime;
		for (SearchWord modifyWord : modifyWords) {
			if (modifyWord.getLastUpdateTime() > lastUpdateTime){
				maxtime = modifyWord.getLastUpdateTime();
			}
			if (currentMap.containsKey(modifyWord.getKeyword())){
				SearchWord searchWord = currentMap.get(modifyWord.getKeyword());
				searchWord.setCount(modifyWord.getCount());
				searchWord.setLastUpdateTime(modifyWord.getLastUpdateTime());
			}else {
				currentMap.put(modifyWord.getKeyword(),modifyWord);
			}
		}
		lastUpdateTime = maxtime;
		keywordMap = currentMap;
	}

	/**
	 * 浅克隆 保证性能，是有存在就删除，再添加来保证数据版本一致
	 */
	public void refreshV4(){
		HashMap<String, SearchWord> currentMap = (HashMap<String,SearchWord>)keywordMap.clone();

		List<SearchWord> modifyWords = getLastModifyData(lastUpdateTime);
		Long maxtime = lastUpdateTime;
		for (SearchWord modifyWord : modifyWords) {
			if (modifyWord.getLastUpdateTime() > lastUpdateTime){
				maxtime = modifyWord.getLastUpdateTime();
			}
			if (currentMap.containsKey(modifyWord.getKeyword())){
				currentMap.remove(modifyWord.getKeyword());
			}
			currentMap.put(modifyWord.getKeyword(),modifyWord);
		}
		lastUpdateTime = maxtime;
		keywordMap = currentMap;
	}


	private List<SearchWord> getLastModifyData(Long lastUpdateTime) {
		return Lists.newArrayList();
	}

}
