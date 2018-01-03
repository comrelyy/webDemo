package com.relyy.VO;

public class StudentInfoOpenDto {
    /*用户*/
    private Long userId;
    /*课程*/
    private Long courseId;
    /*招生*/
    private Integer recruitId;
    /*学校*/
    private Integer schoolId;

    @Override
    public String toString() {
        return "StudentInfoOpenDto{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", recruitId=" + recruitId +
                ", schoolId=" + schoolId +
                '}';
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

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}
