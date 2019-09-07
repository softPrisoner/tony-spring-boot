package com.rainbow.tony.shiro.chapter3;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tony
 * @describe AuthorizerTest
 * @date 2019-09-04
 */
@SuppressWarnings("Duplicates")
public class AuthorizerTest extends BaseTest {
    @Test
    public void testIsPermitted() {
        login("classpath:shiro/chapter3/shiro-authorizer.ini", "zhang", "123");
        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user1:Update"));
        Assert.assertTrue(subject().isPermitted("user2:Update"));
        Assert.assertTrue(subject().isPermitted("+user1+2"));//新增权限
        Assert.assertTrue(subject().isPermitted("+user1+8"));//查看权限
        Assert.assertTrue(subject().isPermitted("+user2+10"));//新增及查看
        Assert.assertFalse(subject().isPermitted("+user1+4"));//没有删除权限
        Assert.assertTrue(subject().isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
    }
}
