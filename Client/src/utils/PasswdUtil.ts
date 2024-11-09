// PasswdUtil.ts
import bcrypt from 'bcryptjs';

export default class PasswdUtil {
    private static rounds: number = 10; // 可以根据需要调整强度

    // 密码加密算法，使用BCrypt
    public static encryptPasswd(passwd: string): string {
        return bcrypt.hashSync(passwd, this.rounds);
    }

    // 验证密码是否正确
    public static verifyPasswd(inputPasswd: string, storedPasswd: string): boolean {
        return bcrypt.compareSync(inputPasswd, storedPasswd);
    }
}
