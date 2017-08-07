package com.acehouhao.domain;

import java.util.Set;

/**
 * Created by Hao HOU on 2017/8/7.
 */
public class UserSetForm {
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }
}
