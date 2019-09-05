package com.rainbow.tony.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author tony
 * @describe Userp
 * @date 2019-08-22
 */
public class UserRealm3 implements Realm {

    public String getName() {
        return "UserRealm";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"lisi".equals(username)) {
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
