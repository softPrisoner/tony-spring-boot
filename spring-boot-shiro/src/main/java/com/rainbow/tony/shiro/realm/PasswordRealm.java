package com.rainbow.tony.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author tony
 * @describe PasswordRealm
 * @date 2019-08-22
 */
public class PasswordRealm extends AuthorizingRealm {
    private PasswordService pswService;

    @Override
    protected boolean hasRole(String roleIdentifier, AuthorizationInfo info) {
        return super.hasRole(roleIdentifier, info);
    }

    public void setPasswordService(PasswordService service) {
        this.pswService = service;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //对token进行校验
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return new SimpleAuthenticationInfo("wu", pswService.encryptPassword("123"), getName());
    }

}
