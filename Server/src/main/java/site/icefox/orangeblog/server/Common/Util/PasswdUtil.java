package site.icefox.orangeblog.server.Common.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswdUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 密码加密算法，使用BCrypt
     *
     * @param passwd the password to encrypt
     * @return the password to encrypt
     */
    public static String encryptPasswd(String passwd) {
        return bCryptPasswordEncoder.encode(passwd);
    }

    /**
     * verify the password
     *
     * @param inputPasswd  the password to verify
     * @param storedPasswd the stored password
     * @return true if the password is correct
     */
    public static boolean verifyPasswd(String inputPasswd, String storedPasswd) {
        return bCryptPasswordEncoder.matches(inputPasswd, storedPasswd);
    }

    /**
     * 验证密码是否符合指定的格式要求。
     *
     * @param password 用户输入的密码
     * @return 如果密码符合要求返回true，否则返回false
     */
    public static boolean isValidPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,32}$";
        return password != null && password.matches(pattern);
    }
}
