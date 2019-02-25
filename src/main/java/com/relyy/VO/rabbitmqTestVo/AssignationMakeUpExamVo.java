package com.relyy.VO.rabbitmqTestVo;

import java.io.Serializable;
import java.util.List;

/**
 * 题库换卷功能jms消息传值对象
 * @author chenjiong
 * @date 2017年4月17日10:09:13
 */
public class AssignationMakeUpExamVo implements Serializable {

	private static final long serialVersionUID = 1587782231123263926L;
	
	private List<Integer> randomChildExamIdList = null;	//随机子卷List，null表示普通卷
	private Long userId;		//用户id
	private Integer recruitId;	//招生id
	private Integer courseId;	//课程id
	private Integer oldExamId;	//教程试卷
	private Integer makeUpExamId;	//补考卷
	private String startTimeStr;	//补考开始试卷
	private String endTimeStr;		//补考结束时间
	
	
	public List<Integer> getRandomChildExamIdList() {
		return randomChildExamIdList;
	}
	public void setRandomChildExamIdList(List<Integer> randomChildExamIdList) {
		this.randomChildExamIdList = randomChildExamIdList;
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
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getOldExamId() {
		return oldExamId;
	}
	public void setOldExamId(Integer oldExamId) {
		this.oldExamId = oldExamId;
	}
	public Integer getMakeUpExamId() {
		return makeUpExamId;
	}
	public void setMakeUpExamId(Integer makeUpExamId) {
		this.makeUpExamId = makeUpExamId;
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	@Override
	public String toString() {
		return "AssignationMakeUpExamVo{" +
				"randomChildExamIdList=" + randomChildExamIdList +
				", userId=" + userId +
				", recruitId=" + recruitId +
				", courseId=" + courseId +
				", oldExamId=" + oldExamId +
				", makeUpExamId=" + makeUpExamId +
				", startTimeStr='" + startTimeStr + '\'' +
				", endTimeStr='" + endTimeStr + '\'' +
				'}';
	}
}
