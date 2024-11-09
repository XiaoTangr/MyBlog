package site.icefox.orangeblog.server.Common.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswdUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    // 密码加密算法，使用BCrypt
    public static String encryptPasswd(String passwd) {
        return bCryptPasswordEncoder.encode(passwd);
    }

    // 验证密码是否正确
    public static boolean verifyPasswd(String inputPasswd, String storedPasswd) {
        return bCryptPasswordEncoder.matches(inputPasswd, storedPasswd);
    }
}
