package com.rainbow.tony.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.io.*;

/**
 * @author tony
 * @describe UserRealm2
 * @date 2019-08-22
 */
public class UserRealm2 implements Realm {

    public String getName() {
        return "UserRealm";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)) {
            try {
                Object object = new Object();
                InputStream in = new FileInputStream("/home/tony/test/user.txt");
                ObjectInputStream objectInputStream = new MyObjectInputStream(in);
                Object readObject = objectInputStream.readObject();
                System.out.println(readObject);
                OutputStream out = new FileOutputStream("/home/tony/test/user.txt");
                out = new MyObjectOutputStream(out);
                ObjectOutputStream objectOutputStream = new MyObjectOutputStream(out);
                objectOutputStream.writeObject(object);
                throw new IncorrectCredentialsException();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
