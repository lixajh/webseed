package com.peake.webseed.dao;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.model.TblNews;

import java.util.Date;

public interface TblNewsMapper extends Mapper<TblNews> {
    TblNews findByDate(Date date);
}