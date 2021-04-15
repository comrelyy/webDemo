package com.relyy.jdkdemo.Demo;

public class TeamStudentOpenDto {
    /*用户Id*/
    private Long userId;
    /*用户头像*/
    private String avatarUrl;
    /*用户所在关卡位置,默认是第一关*/
    private Integer location = 1;

    public TeamStudentOpenDto(Long userId, String avatarUrl, Integer location){
        this.userId = userId;
        this.avatarUrl = avatarUrl;
        this.location = location;
    }

    @Override
    public String toString() {
        return "TeamStudentOpenDto{" +
                "userId=" + userId +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", location=" + location +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
