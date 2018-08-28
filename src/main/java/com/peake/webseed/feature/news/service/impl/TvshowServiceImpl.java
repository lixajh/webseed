package com.peake.webseed.feature.news.service.impl;

import com.peake.webseed.feature.news.mapper.TvshowMapper;
import com.peake.webseed.feature.news.model.Tvshow;
import com.peake.webseed.feature.news.service.TvshowService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/14.
 */
@Service
@Transactional
public class TvshowServiceImpl extends AbstractService<Tvshow> implements TvshowService {
    @Resource
    private TvshowMapper tvshowMapper;

}
