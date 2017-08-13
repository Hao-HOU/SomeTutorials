package com.acehouhao.simple.mapper;

import com.acehouhao.simple.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Hao HOU on 2017/8/11.
 */
public class PrivilegeMapperTest extends BaseMapperTest{
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege privilege = privilegeMapper.selectById(1L);
            Assert.assertNotNull(privilege);
            Assert.assertEquals("用户管理", privilege.getPrivilegeName());
        } finally {
            sqlSession.close();
        }
    }
}
