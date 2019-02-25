package com.relyy.VO.rabbitmqTestVo;

/**
 * DESCRIPTION〈〉
 * CREATE 2018/10/18
 *
 * @author luxufeng
 */
public class StudiedExamMqDto {
    /* 招生 */
    private Integer recruitId;
    /* 用户 */
    private Long userId;
    /* 班级 */
    private Integer classId;

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
