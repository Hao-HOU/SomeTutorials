package com.acehouhao.simple.mapper;

import com.acehouhao.simple.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by Hao HOU on 2017/8/8.
 */
public interface PrivilegeMapper {
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
