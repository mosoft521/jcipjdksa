package com.gmail.mosoft521.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String userName;
    private String userPwd;
    private int deptmentId;
    private String userTrueName;
    private String email;
    private int learnCenterId;
    private Date createDate;
    private Date lastModifyDate;
    private int userStatus;
}