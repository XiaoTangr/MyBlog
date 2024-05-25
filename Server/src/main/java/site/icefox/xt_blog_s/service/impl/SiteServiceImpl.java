package site.icefox.xt_blog_s.service.impl;

import org.springframework.stereotype.Service;
import site.icefox.xt_blog_s.service.SiteService;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    
    @Override
    public List<SiteService> getAllSiteData() {
        return List.of();
    }
}
