package com.acehouhao.simple.mapper;

import com.acehouhao.simple.model.SysPrivilege;
import com.acehouhao.simple.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Hao HOU on 2017/8/11.
 */
public class RoleMapperTest extends BaseMapperTest{
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById2(1L);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectAll();
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
            Assert.assertNotNull(roleList.get(0).getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAllRoleAndPrivileges() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectAllRoleAndPrivileges();
            System.out.println("角色数：" + roleList.size());
            for (SysRole role : roleList) {
                System.out.println("角色名：" + role.getRoleName());
                for (SysPrivilege privilege : role.getPrivilegeList()) {
                    System.out.println("|-权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectRoleByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
            for (SysRole role : roleList) {
                System.out.println("角色名：" + role.getRoleName());
                for (SysPrivilege privilege : role.getPrivilegeList()) {
                    System.out.println("|-权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserIdChoose() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectRoleByUserIdChoose(1L);
            for (SysRole r : roleList) {
                System.out.println("角色名：" + r.getRoleName());
                if (r.getId().equals(1L)) {
                    Assert.assertNotNull(r.getPrivilegeList());
                } else if (r.getId().equals(2L)) {
                    Assert.assertNull(r.getPrivilegeList());
                    continue;
                }
                for (SysPrivilege privilege : r.getPrivilegeList()) {
                    System.out.println("权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }
    }
}
