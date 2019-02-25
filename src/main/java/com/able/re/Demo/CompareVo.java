package com.able.re.Demo;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/1/29
 */
public class CompareVo {

        private Integer id = 0;
        private Integer meetType = 0;
        private Integer recruitIdType = 0;

    CompareVo(Integer id,Integer meetType,Integer recruitIdType){
            this.id = id;
            this.meetType = meetType;
            this.recruitIdType = recruitIdType;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    public Integer getMeetType() {
        return meetType;
    }

    public void setMeetType(Integer meetType) {
        this.meetType = meetType;
    }

    public Integer getRecruitIdType() {
        return recruitIdType;
    }

    public void setRecruitIdType(Integer recruitIdType) {
        this.recruitIdType = recruitIdType;
    }

    @Override
    public String toString() {
        return "CompareVo{" +
                "id=" + id +
                ", meetType=" + meetType +
                ", recruitIdType=" + recruitIdType +
                '}';
    }
}
