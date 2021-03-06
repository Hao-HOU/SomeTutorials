package com.acehouhao.simple.mapper;

import com.acehouhao.simple.model.SysRole;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Hao HOU on 2017/8/8.
 */
public interface RoleMapper {
    @Select({"select id, role_name roleName, enabled, create_by createBy," +
            "create_time createTime from sys_role where id = #{id}"})
    SysRole selectById(Long id);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id, role_name, enabled, create_by, create_time from sys_role where id = #{id}"})
    SysRole selectById2(Long id);

    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    int selectRoleById(Long id);

    List<SysRole> selectAllRoleAndPrivileges();

    List<SysRole> selectRoleByUserId(Long id);

    List<SysRole> selectRoleByUserIdChoose(Long userId);
}
