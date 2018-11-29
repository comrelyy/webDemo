package com.relyy.shardingAlgorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
public class UserSingleKeyDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {

    //sql中关键字匹配符为=的时候，表的路由函数
    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        for (String avalilableTargetName : collection) {
            if (avalilableTargetName.endsWith(shardingValue.getValue() % 2 +"")) {
                return avalilableTargetName;
            }
        }
        throw  new IllegalArgumentException();
    }

    //sql中关键字匹配符为in的时候，表的路由函数
    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        for (Integer value : shardingValue.getValues()) {
            for (String avalilableTargetName : collection) {
                if (avalilableTargetName.endsWith(value % 2 + "")){
                    result.add(avalilableTargetName);
                }
            }
        }
        return result;
    }

    //sql 中关键字匹配符为between的时候，表的路由函数
    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<Integer> range = (Range<Integer>) shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++){
            for (String availableTargetName : collection) {
                if (availableTargetName.endsWith(i % 2 + "")) {
                    result.add(availableTargetName);
                }
            }
        }
        return result;
    }
}
