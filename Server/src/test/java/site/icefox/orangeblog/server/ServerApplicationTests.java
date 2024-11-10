package site.icefox.orangeblog.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.icefox.orangeblog.server.Common.Util.PasswdUtil;
import site.icefox.orangeblog.server.api.Service.Impl.UsersServiceImpl;

@SpringBootTest
class ServerApplicationTests {
    @Autowired
    UsersServiceImpl service;

    @Test
    void contextLoads() throws Exception {
    }

    @Test
    void testEncryptPasswd() {
    }
}
