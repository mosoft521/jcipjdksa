package com.gmail.mosoft521.mybatis;

import com.gmail.mosoft521.mybatis.pojo.User;
import com.gmail.mosoft521.mybatis.ser.IUser;
import com.gmail.mosoft521.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            IUser iUser = sqlSession.getMapper(IUser.class);
            List<User> users = iUser.queryUsers();
            if (users.size() > 0) {
                for (User user : users) {
                    System.out.println(user.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}