package com.relyy.jdkdemo.Demo;

public enum RewardDemo {

    FIRST_OPEN_MISSION(1),//首次进入闯关模式
    CHANGE_HEAD_PICTURE(2),//修改头像
    COMPLETE_LIVE_TASK(3),//完成见面课任务
    COMPLETE_EAXM_TASK(4),//完成考试任务
    PASS_MISSION_SHARE(5),//过关分享
    WEEK_RANK_FIRST(6),//周排行榜第一名
    WEEK_RANK_SECOND(7),//周排行榜第二名
    WEEK_RANK_THIRDLY(8),//周排行榜第三名
    WACTH_ONE_MINUTE(9);//关卡内看视频一分钟

    private Integer rewardtype;//奖励类型

    private RewardDemo(Integer rewardtype){
        this.rewardtype = rewardtype;
    }

    public Integer getValue(){
        return this.rewardtype;
    }
}
