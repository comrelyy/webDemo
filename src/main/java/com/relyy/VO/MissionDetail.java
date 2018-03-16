package com.relyy.VO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class MissionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键id */
    private Integer id;
    /** 关卡主键id */
    private Integer missionId;
    /** 用户id */
    private Long userId;
    /** 招生id */
    private Integer recruitId;
    /** 课程id */
    private Long courseId;
    /** 视频/作业 标志。1：视频；2：作业； */
    private Integer type;
    /** 视频章id */
    private Integer chapterId;
    /** 视频节id */
    private Integer lessonId;
    /** 视频小节id */
    private Integer lessonVideoId;
    /** 作业id */
    private Integer examId;
    /** 学生作业id */
    private Integer studentExamId;
    /** 视频观看时长(单位：分)，默认为0 */
    private Integer watchTime;
    /** 创建时间 */
    private Date createTime;
    /** 删除状态，默认为0。 0：未删除；1：已删除； */
    private Integer isDeleted;
    /** 更新时间 */
    private Date updateTime;
    /** 关卡顺序 **/
    private Integer orderNum;

    @Override
    public String toString() {
        return "MissionDetail{" +
                "id=" + id +
                ", missionId=" + missionId +
                ", userId=" + userId +
                ", recruitId=" + recruitId +
                ", courseId=" + courseId +
                ", type=" + type +
                ", chapterId=" + chapterId +
                ", lessonId=" + lessonId +
                ", lessonVideoId=" + lessonVideoId +
                ", examId=" + examId +
                ", studentExamId=" + studentExamId +
                ", watchTime=" + watchTime +
                ", createTime=" + createTime +
                ", isDeleted=" + isDeleted +
                ", updateTime=" + updateTime +
                ", orderNum=" + orderNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getStudentExamId() {
        return studentExamId;
    }

    public void setStudentExamId(Integer studentExamId) {
        this.studentExamId = studentExamId;
    }

    public Integer getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Integer watchTime) {
        this.watchTime = watchTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }
}
