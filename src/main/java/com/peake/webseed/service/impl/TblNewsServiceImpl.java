package com.peake.webseed.service.impl;

import com.peake.webseed.core.AbstractService;
import com.peake.webseed.dao.TblNewsMapper;
import com.peake.webseed.model.TblNews;
import com.peake.webseed.service.TblNewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by CodeGenerator on 2017/12/19.
 */
@Service
@Transactional
public class TblNewsServiceImpl extends AbstractService<TblNews> implements TblNewsService {
    @Resource
    private TblNewsMapper tblNewsMapper;

    public TblNews findByDate(Date date){
       return tblNewsMapper.findByDate(date);
    }
}
