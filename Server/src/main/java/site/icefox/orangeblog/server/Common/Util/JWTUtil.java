package site.icefox.orangeblog.server.Common.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class JWTUtil {

    @Data
    public static class TokenBody {
        private String user_name;
        private String user_email;
        private int user_role;
    }


    // 移除static关键字，并使用@Value注解注入配置文件中的值
    private static String ISSUER;
    private static String SECRET_KEY;
    private static long EXPIRATION_TIME; // 10 days in milliseconds

    @Value("${jwt.secret}")
    public void setSECRET_KEY(String secretKey) {
        SECRET_KEY = secretKey;
    }


    @Value("${jwt.issuer}")
    public void setISSUUER(String issuuer) {
        ISSUER = issuuer;
    }

    @Value("${jwt.expiration_time}")
    public void setEXPIRATION_TIME(long expirationTime) {
        EXPIRATION_TIME = expirationTime;
    }

    /**
     * 构建Token
     *
     * @param tokenBody Object
     * @return String
     */
    public static String generateToken(TokenBody tokenBody) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("user_name", tokenBody.getUser_name())
                    .withClaim("user_email", tokenBody.getUser_email())
                    .withClaim("user_role", tokenBody.getUser_role())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / couldn't convert Claims.
            return null;
        }
    }

    /**
     * 验证Token
     *
     * @param token string
     * @return Boolean
     */
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
            return false;
        }
    }


    /**
     * 获取Token中的信息
     *
     * @param token String
     * @return TokenBody
     */
    public static TokenBody getTokenBody(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            TokenBody tokenBody = new TokenBody();
            tokenBody.setUser_name(jwt.getClaim("user_name").asString());
            tokenBody.setUser_email(jwt.getClaim("user_email").asString());
            tokenBody.setUser_role(jwt.getClaim("user_role").asInt());
            return tokenBody;
        } catch (JWTDecodeException exception) {
            // 解码失败
            return null;
        }
    }
}
