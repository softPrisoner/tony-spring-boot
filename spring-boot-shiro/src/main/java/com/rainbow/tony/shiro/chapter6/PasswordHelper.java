package com.rainbow.tony.shiro.chapter6;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author tony
 * @describe PasswordHelper
 * @date 2019-09-07
 */
public class PasswordHelper {
    //shiro里面的random generator
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static final int hashIterators = 6;

    //md5
    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, user.getPassword()
                , ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterators).toHex();
        user.setPassword(newPassword);
    }
}
