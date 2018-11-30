package com.relyy.shardingAlgorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
public class StudentSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {
    @Override
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        for (String name : tableNames) {
            if (name.endsWith("0".concat(String.valueOf(shardingValue.getValue() % 2)))) {
                return name;
            }
        }
        throw  new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        for (Integer value : shardingValue.getValues()) {
            for (String name : tableNames) {
                if (name.endsWith("0".concat(String.valueOf(value % 2)))){
                    result.add(name);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        Range<Integer> range = (Range<Integer>) shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++){
            for (String name : tableNames) {
                if (name.endsWith("0".concat(String.valueOf(i % 2)))) {
                    result.add(name);
                }
            }
        }
        return result;
    }
}
