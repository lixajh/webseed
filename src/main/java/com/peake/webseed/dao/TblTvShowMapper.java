package com.peake.webseed.dao;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.model.TblTvShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface TblTvShowMapper extends Mapper<TblTvShow> {
    List<String> getList(@Param("date") Date date, @Param("addMonth")int addMonth);
    Map<String, Object> getRecord(String date);
    TblTvShow getToday();
    void enableRecordBeforeToday(@Param("date") Date date);
    Integer getMinLeftOffset(@Param("oldOffset") int oldOffset, @Param("date")Date date);
    Integer getMinRightOffset(@Param("oldOffset") int oldOffset, @Param("date")Date date);
}