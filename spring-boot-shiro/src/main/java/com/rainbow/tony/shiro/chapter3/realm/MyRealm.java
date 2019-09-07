package com.rainbow.tony.shiro.chapter3.realm;

import com.rainbow.tony.shiro.chapter3.permission.BitPermission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author tony
 * @describe MyRealm
 * @date 2019-09-04
 */
//受保护资源???
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.addRole("role1");
        authenticationInfo.addRole("role2");
        authenticationInfo.addObjectPermission(new BitPermission("+user1+10"));
        authenticationInfo.addObjectPermission(new WildcardPermission("user1:*"));
        authenticationInfo.addStringPermission("+user2+10");
        authenticationInfo.addStringPermission("user2:*");
        return authenticationInfo;
    }

    @Override
    public String getName() {
        return "Chapter3Realm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        //密码char数组
        String password = new String((char[]) authenticationToken.getCredentials());
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException(username + "is not permit");
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException(password + " is wrong");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
