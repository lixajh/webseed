package com.peake.webseed.feature.news.service.impl;

import com.peake.webseed.feature.news.mapper.NewsMapper;
import com.peake.webseed.feature.news.model.News;
import com.peake.webseed.feature.news.service.NewsService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/14.
 */
@Service
@Transactional
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

}
