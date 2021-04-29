package com.kc.july;

import com.utils.JsonUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-28
 */
public class ColleutilsDemo {

    public static void main(String[] args) {


        List<Integer> app = Arrays.asList(2025798, 2025797, 2025762, 2025690, 2025650, 2025627, 2025570, 2025518, 2025514, 2025429, 2025420,
                    2025379, 2025377, 2025376, 2025371, 2025360, 2025266, 2025235, 2025210, 2025169, 2025168, 2025160,
                    2025095, 2024977, 2024976, 2024975, 2024842, 2024838, 2024839, 2024846, 2024841, 2024837, 2024840,
                    2024843, 2024845, 2024836, 2024835, 2024833, 2024834, 2024831, 2024830, 2024829, 2024828, 2024738);

        List<Integer> cachel = Arrays.asList(2024526,2024576,2024733,2024738,2024783,2024824,2024825,2024827,2024828,2024829,2024830,2024831,2024833,2024834,2024835,
                2024836,2024837,2024838,2024839,2024840,2024841,2024842,2024843,2024845,2024846,2024976,2024977,2025047,2025049,2025050,
                2025063,2025095,2025160,2025168,2025169,2025235,2025266);

        //比较:相等直接返回
        //boolean flag = CollectionUtils.isEqualCollection(app, cachel);

        //列出两个列表相同的元素
        Collection collection = CollectionUtils.retainAll(app, cachel);
        //列出需要删除的元素
        Collection needDelete = CollectionUtils.removeAll(cachel, collection);
        //列出需要增加的元素
        Collection needAdd = CollectionUtils.removeAll(app, collection);

        System.out.println("列出两个列表相同的元素----"+JsonUtil.toJson(collection));
        System.out.println("列出需要删除的元素----"+JsonUtil.toJson(needDelete));
        System.out.println("列出需要增加的元素----"+JsonUtil.toJson(needAdd));

    }
}
