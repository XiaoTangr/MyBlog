package site.icefox.XtBlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.icefox.XtBlog.entity.Site;


import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SiteMapper {
    List<Site> SelectAll();

    List<Site> SelectOneById(@Param("id") int id);

    List<Site> SelectOneByKey(@Param("key") String key);
}
