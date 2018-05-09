package com.peake.webseed.service.impl;

import com.peake.webseed.core.AbstractService;
import com.peake.webseed.dao.TblTvShowMapper;
import com.peake.webseed.model.TblTvShow;
import com.peake.webseed.service.TblTvShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/12/19.
 */
@Service
@Transactional
public class TblTvShowServiceImpl extends AbstractService<TblTvShow> implements TblTvShowService {
    private final Logger logger = LoggerFactory.getLogger(TblTvShowServiceImpl.class);
    @Resource
    private TblTvShowMapper tblTvShowMapper;

    @Override
    public TblTvShow getToday() {
        return tblTvShowMapper.getToday();
    }

    @Override
    public List<String> getList(Date date, int addMonth) {

        Integer latestOffset = getLatestOffset(addMonth, date);
        if(latestOffset != null){
            return tblTvShowMapper.getList(date,latestOffset);
        }
        return tblTvShowMapper.getList(date, addMonth);
    }

    @Override
    public Map<String, Object> getRecord(String date) {

        return tblTvShowMapper.getRecord(date);
    }

    @Override
    public void enableRecordBeforeToday() {
        LocalDateTime now = LocalDateTime.now();
        now = now.minusYears(12);
        if (now.getHour() < 23){
            now = now.minusDays(1);
        }

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(zoneId);
        Date nowDate = Date.from(zdt.toInstant());
        logger.info("nowDate:"+nowDate);
        tblTvShowMapper.enableRecordBeforeToday(nowDate);
    }

    private Integer getLatestOffset(int offset,Date date){
        if (offset < 0){
            return tblTvShowMapper.getMinLeftOffset(offset,date);
        }else{
            return tblTvShowMapper.getMinRightOffset(offset,date);
        }
    }
}
