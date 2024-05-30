package site.icefox.XtBlog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.icefox.XtBlog.entity.Site;
import site.icefox.XtBlog.mapper.SiteMapper;


import java.util.List;

@SpringBootTest
class XtBlogSApplicationTests {
    @Autowired
    SiteMapper siteMapper;

    @Test
    public void testFindAll() {
        List<Site> list = siteMapper.SelectAll();
        System.out.println(list);
    }

    @Test
    public void testFindOneById() {
        List<Site> list = siteMapper.SelectOneById(1);
        System.out.println(list);
    }

    @Test
    public void testFindOneByKey(){
        List<Site> list = siteMapper.SelectOneByKey("SiteName");
        System.out.println(list);
    }
}
