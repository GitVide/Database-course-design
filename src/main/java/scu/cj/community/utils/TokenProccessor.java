package scu.cj.community.utils;

/**
 * @author : lkk
 * @date : 11:00 2019/12/15
 * @creed: Talk is cheap,show me the code
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.UUID;

//import sun.misc.BASE64Encoder;

/**
 * 生成Token的工具类
 *
 */
public class TokenProccessor {

    private TokenProccessor(){};
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     * @return
     */
    public String makeToken() {
//        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        String token = UUID.randomUUID().toString().replaceAll("-", "+") + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TokenProccessor token = new TokenProccessor();
        String tokens = token.makeToken();
        System.out.println(tokens);

    }

}

