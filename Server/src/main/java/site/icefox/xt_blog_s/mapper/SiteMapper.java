package site.icefox.xt_blog_s.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.icefox.xt_blog_s.entity.Site;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SiteMapper {
    List<Site> SelectAll();

    List<Site> SelectOneById(@Param("id") int id);

    List<Site> SelectOneByKey(@Param("key") String key);
}
