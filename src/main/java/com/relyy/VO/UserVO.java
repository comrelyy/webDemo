package com.relyy.VO;

import java.util.Date;

/**
 * 测试
 *
 * @author cairuirui
 * @date 2017-10-17
 */
public class UserVO {

    private Integer id;
    private String name;
    private Date createTime;

    public UserVO() {
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
