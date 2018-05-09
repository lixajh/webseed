package com.peake.webseed.service;
import com.peake.webseed.core.Service;
import com.peake.webseed.model.TblNews;

import java.util.Date;


/**
 * Created by CodeGenerator on 2017/12/19.
 */
public interface TblNewsService extends Service<TblNews> {
    TblNews findByDate(Date date);
}
