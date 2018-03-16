package com.able.re.ThreadDemo.comsumerAndProducer;

import java.io.Serializable;
import java.util.Date;

public class UserVideoStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    /*主键*/
    private Integer id;
    /*用户*/
    private Long userId;
    /*课程*/
    private Long courseId;
    /*招生*/
    private Integer recruitId;
    /*章*/
    private Integer chapterId;
    /*节*/
    private Integer lessonId;
    /*小节*/
    private Integer lessonVideoId;
    /*时间段*/
    private String time;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
    /*删除状态，0：未删除；1：删除*/
    private Integer isDelete;
    /*视频id*/
    private Integer videoId;

    public UserVideoStatistics(Long userId, Long courseId, Integer lessonId, Integer lessonVideoId, String time) {
        this.userId = userId;
        this.courseId = courseId;
        this.lessonId = lessonId;
        this.lessonVideoId = lessonVideoId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserVideoStatistics{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", recruitId=" + recruitId +
                ", chapterId=" + chapterId +
                ", lessonId=" + lessonId +
                ", lessonVideoId=" + lessonVideoId +
                ", time='" + time + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", videoId=" + videoId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getLessonVideoId() {
        return lessonVideoId;
    }

    public void setLessonVideoId(Integer lessonVideoId) {
        this.lessonVideoId = lessonVideoId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
