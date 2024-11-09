package site.icefox.orangeblog.server.Common.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;

import java.util.Date;

public class JWTUtil {

    @Data
    public static class TokenBody {
        private String user_name;
        private String user_email;
        private String user_role;
    }

    private static final String SECRET_KEY = "secretsecretsecret";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds


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
                    .withIssuer("librarysys")
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
                    .withIssuer("librarysys")
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
            tokenBody.setUser_role(jwt.getClaim("user_role").asString());
            return tokenBody;
        } catch (JWTDecodeException exception) {
            // 解码失败
            return null;
        }
    }
}
