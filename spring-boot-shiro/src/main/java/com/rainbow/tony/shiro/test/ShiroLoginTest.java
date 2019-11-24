package com.rainbow.tony.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.SimpleByteSource;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ShiroLoginTest {

    private void init(String iniPath) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
    }

    private Subject login(String iniPath, String username, String password) {
        init(iniPath);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("LOGIN|username:" + username + ",password:" + password + " login success~~");
        } catch (AuthenticationException e) {
            System.out.println("LOGIN|username:[" + username + "],password:[" + password + "] login failed~~");
        } finally {
            //fix bug需求不能退出
            // subject.logout();
        }
        return subject;
    }

    @Test
    public void test_shiro_password_service() {
        login("classpath:shiro/shiro-password-service.ini", "abc", "123");
    }

    @Test
    public void test_shiro() {
        login("classpath:shiro/shiro.ini", "zhang", "123");
    }

    @Test
    public void test_shiro_realm() {
        login("classpath:shiro/shiro-realm.ini", "zhang", "123");
    }

    @Test
    public void test_shiro_multi_realm() {
        login("classpath:shiro/shiro-multi-realm.ini", "zhang", "12345");
    }

    @Test
    public void test_shiro_jdbc_realm() {
        login("classpath:shiro/shiro-jdbc-realm.ini", "zhangsan1", "123456");
    }

    /**
     * FirstSuccessfulStrategy只要有一个即可 只返回第一个
     * AllSuccessfulStrategy 所有都要成功才可以 所有都返回
     * AtLeastOneSuccessfulStrategy至少一个要成功 所有都返回
     */
    @Test
    public void test_shiro_authenticator_all_success() {
        login("classpath:shiro/shiro-authenticator-all-strategy.ini", "zhangsan", "123");
    }

    @Test

    public void test_shiro_authenticator_first_success() {
        //调用链会继续往下执行
        login("classpath:shiro/shiro-authenticator-all-strategy.ini", "zhangsan", "123");
    }

    @Test
    public void test_shiro_authenticator_at_least_one() {
        login("classpath:shiro/shiro-authenticator-all-strategy.ini", "zhangsan", "123");
    }

    //\----------------------------------roles permission-------------------------------------------------------------\//
    @Test
    public void test_ShiroRoles() {
        Subject login = login("classpath:shiro/shiro-roles.ini", "zhangsan", "123");
        //断言是否拥有role1角色
        assertTrue(login.hasRole("role1"));
        //断言是否拥有role1和role2角色
        assertTrue(login.hasAllRoles(Arrays.asList("role1", "role2")));
        //判断是否拥有role1,role2,role3角色
        boolean[] result = login.hasRoles(Arrays.asList("role1", "role2", "role3"));
        assertEquals(true, result[0]);
        assertEquals(true, result[1]);
        assertEquals(false, result[2]);
    }

    /**
     * roles permission
     */
    @Test
    public void checkRoles() {
        Subject subject = login("classpath:shiro/shiro-roles.ini", "zhangsan", "123");
        subject.checkRole("role1");
        subject.checkRoles(Arrays.asList("role1", "role2"));
        subject.checkRoles("role1", "role2");
        //檢查是否有role1角色
        if (subject.hasRole("role1")) {
            System.out.println("has role1 permission");
        } else {
            System.out.println("no role1 permission");
        }
    }

    @Test
    public void testPermission() {
        Subject login = login("classpath:shiro/shiro-roles.ini", "zhangsan", "123");
        // 断言拥有权限：user:create
        login.checkPermission("system:user:create");
        login.isPermitted("system:user:create");
        // 断言拥有权限：user:delete and user:update
        //资源标识符+操作
        login.checkPermissions("system:user:delete", "system:user:update");
        // 断言拥有权限：user:view 失败抛出异常
        login.checkPermissions("system:user:view");
    }

    //\------------------------------------------------chapter4 crypt-----------------------------------------------------//
    private static final String clearText = "tony";

    // TODO: 19-9-6 查看并分析算法源码
    @Test
    public void testBase64Algorithm() {
        //base 64 encrypt and decrypt
        String encryptText = Base64.encodeToString(clearText.getBytes());
        System.out.println("使用Base64加密后的明文:" + encryptText);
        String decryptText = Base64.decodeToString(encryptText.getBytes());
        System.out.println("使用Base64解密后的明文:" + decryptText);

    }

    @Test
    public void testHexAlgorithm() {
        //HEX编码
        String encryptText = Hex.encodeToString(clearText.getBytes());
        System.out.printf("base64Encoded value: %s\r\n", encryptText);
        String decryptText = new String(Hex.decode(encryptText.getBytes()));
        System.out.printf("base64Decoded value:%s\n", decryptText);
    }

    @Test
    public void testMD5Algorithm() {
        //自定义salt
        String salt = "RBSalt";
        String md5 = new Md5Hash(clearText, salt, 2).toString();
        System.out.println("MD5:" + md5);
        // sha256 sha1 sha512
        String sha1 = new Sha256Hash(clearText, salt).toString();
        System.out.println("SHA:" + sha1);
        String simpleHash = new SimpleHash("SHA-1", clearText, salt).toString();
        System.out.println("SimpleHash:" + simpleHash);
    }

    //defaultHashService SH5-512加密算法
    @Test
    public void testHashService() {
        String salt = "RBSalt";
        String privateSalt = "PV_SALT";
        DefaultHashService service = new DefaultHashService();// 默认使用的是SHA-512算法
        service.setHashAlgorithmName("SH5-512");// 使用SHA512算法
        service.setPrivateSalt(new SimpleByteSource(privateSalt));// 设置私盐
        service.setGeneratePublicSalt(true);
        service.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        service.setHashIterations(1);// 设置hash迭代次数
        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5")
                .setSource(ByteSource.Util.bytes(clearText))
                .setSalt(ByteSource.Util.bytes(salt))
                .setIterations(1) //算法迭代次数
                .build();
        String hex = service.computeHash(request).toHex();
        System.out.println("hex:" + hex);
    }

    /**
     * 对称加密算法AES Blowfish
     */
    @Test
    public void testAesAndBlowfishAlgorithm() {
        // AES加密算法
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); // 设置key长度
        // 生成key
        Key key = aesCipherService.generateNewKey();
        String encryptText = aesCipherService.encrypt(clearText.getBytes(), key.getEncoded()).toHex();
        String decryptText = new String(aesCipherService.decrypt(Hex.decode(encryptText), key.getEncoded()).getBytes());
        System.out.println("AES算法加密之前:" + clearText);
        System.out.println("AES算法加密之后:" + encryptText);
        System.out.println("AES算法解密之后:" + decryptText);
        Assert.assertEquals(clearText, decryptText);
        // blowFish算法
        BlowfishCipherService blowfish = new BlowfishCipherService();
        blowfish.setKeySize(128);
        blowfish.generateNewKey();
        String encryptByBlowfish = blowfish.encrypt(clearText.getBytes(), key.getEncoded()).toHex();
        String decryptByBlowfish = new String(blowfish.decrypt(Hex.decode(encryptByBlowfish), key.getEncoded()).getBytes());
        System.out.println("Blowfish算法加密之前:" + clearText);
        System.out.println("Blowfish算法加密之后:" + encryptByBlowfish);
        System.out.println("AES算法解密之后:" + decryptByBlowfish);
        Assert.assertEquals(clearText, decryptByBlowfish);
    }

    @Test
    public void testHashBase16() {
        String s = "tony";
        String secret = Base64.encodeToString(s.getBytes());
        System.out.println("使用Base64加密后的明文" + secret);
        String decode = Base64.decodeToString(secret.getBytes());
        System.out.println("使用Base64解密后的明文" + decode);
        String str = "tony";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        System.out.println(str2);
    }

    @Test
    public void testHashMD5() {
        // md5加密算法
        String salt = "123456";
        String md5 = new Md5Hash(clearText, salt, 2).toString();
        System.out.println(md5);
        // sha256 sha1 sha512
        String sha1 = new Sha256Hash(clearText, salt).toString();
        String simpleHash = new SimpleHash("SHA-1", clearText, salt).toString();
        System.out.println(sha1);
        System.out.println(simpleHash);
    }


    @After
    public void after() {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

}
