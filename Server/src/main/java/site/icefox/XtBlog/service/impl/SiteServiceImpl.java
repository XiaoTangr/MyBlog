package site.icefox.XtBlog.service.impl;

import org.springframework.stereotype.Service;
import site.icefox.XtBlog.mapper.SiteMapper;


import java.util.List;

@Service
public class SiteServiceImpl implements site.icefox.XtBlog.service.SiteService {

    private SiteMapper siteMapper;

    @Override
    public List<site.icefox.XtBlog.service.SiteService> getAllSiteData() {
//        return siteMapper.SelectAll();
        return null;
    }
}
