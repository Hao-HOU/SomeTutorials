package com.acehouhao.simple.mapper;

import com.acehouhao.simple.model.SysRole;
import com.acehouhao.simple.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hao HOU on 2017/8/8.
 */
public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);

    int insert2(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId,
                                                    @Param("enabled") Integer enabled);

    List<SysUser> selectByUser(SysUser sysUser);

    int updateByIdSelective(SysUser sysUser);

    SysUser selectByIdOrUserName(SysUser sysUser);
}
