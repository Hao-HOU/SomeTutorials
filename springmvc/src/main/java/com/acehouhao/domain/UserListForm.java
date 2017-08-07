package com.acehouhao.domain;

import java.util.List;

/**
 * Created by Hao HOU on 2017/8/7.
 */
public class UserListForm {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
