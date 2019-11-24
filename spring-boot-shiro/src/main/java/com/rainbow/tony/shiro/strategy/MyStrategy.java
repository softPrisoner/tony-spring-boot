package com.rainbow.tony.shiro.strategy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;

/**
 * @author tony
 * @describe MyStrategy
 * @date 2019-08-22
 */
public class MyStrategy implements AuthenticationStrategy {
    public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> realms, AuthenticationToken token)
            throws AuthenticationException {
        for (Realm realm : realms) {
            final PrincipalCollection principals = realm.getAuthenticationInfo(token).getPrincipals();
            final Object credentials = realm.getAuthenticationInfo(token).getCredentials();
        }
        // TODO Auto-generated method stub
        return null;
    }

    //在之后进行做一次日志处理
    //每次执行都进行处理
    public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }

    //在每次之后做一次日志处理
    public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo,
                                           AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
        return null;
    }

    //在所有完成之后提示信息
    //或者附加信息
    @RequiresRoles("admin")
    public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }


}
