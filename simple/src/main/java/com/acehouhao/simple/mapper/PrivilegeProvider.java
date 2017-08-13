package com.acehouhao.simple.mapper;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Hao HOU on 2017/8/11.
 */
public class PrivilegeProvider {
    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
