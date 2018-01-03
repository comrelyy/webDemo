package com.relyy.VO;

public class CourseChangeOpenDto {
    private Integer addCourse;
    private Integer addMission;
    private Integer delCourse;
    private Integer delMission;

    public CourseChangeOpenDto() {
    }

    @Override
    public String toString() {
        return "CourseChangeOpenDto{addCourse=" + this.addCourse + ", addMission=" + this.addMission + ", delCourse=" + this.delCourse + ", delMission=" + this.delMission + '}';
    }

    public Integer getAddCourse() {
        return this.addCourse;
    }

    public void setAddCourse(Integer addCourse) {
        this.addCourse = addCourse;
    }

    public Integer getAddMission() {
        return this.addMission;
    }

    public void setAddMission(Integer addMission) {
        this.addMission = addMission;
    }

    public Integer getDelCourse() {
        return this.delCourse;
    }

    public void setDelCourse(Integer delCourse) {
        this.delCourse = delCourse;
    }

    public Integer getDelMission() {
        return this.delMission;
    }

    public void setDelMission(Integer delMission) {
        this.delMission = delMission;
    }
}
