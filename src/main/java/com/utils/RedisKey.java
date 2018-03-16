package com.utils;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class RedisKey {

    public final static String getUserVideoStatisticsKey(Long userId, Integer chapterId, Integer lessonId, Integer lvId) {
        if (lvId != null) {
            return "sg:n:u:"+userId+":c:"+chapterId+":lv:"+lvId;
        } else {
            return "sg:n:u:"+userId+":c:"+chapterId+":l:"+lessonId;
        }
    }
}
