package com.rainbow.tony.shiro.realm;

import com.rainbow.tony.shiro.domain.AccountLoginDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author tony
 * @describe UserRealm
 * @date 2019-08-22
 */
public class UserRealm implements Realm {

    public String getName() {
        return "UserRealm";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        AccountLoginDO accountLoginDO = new AccountLoginDO();
        accountLoginDO.setUsername(username).setPassword(password);
        if (!username.equals("zhangsan") || !password.equals("123")) {
            throw new AuthenticationException("auth failed username:{}");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
