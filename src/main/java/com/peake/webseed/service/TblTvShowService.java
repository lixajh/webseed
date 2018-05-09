package com.peake.webseed.service;
import com.peake.webseed.core.Service;
import com.peake.webseed.model.TblTvShow;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/12/19.
 */
public interface TblTvShowService extends Service<TblTvShow> {
    TblTvShow getToday();
    List<String> getList(Date date, int addMonth) ;
    Map<String,Object> getRecord(String date);
    void enableRecordBeforeToday();//使今天之前的所有记录都可用
}
