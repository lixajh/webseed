package com.peake.webseed.feature.sysUser.service.impl;

import com.peake.webseed.feature.sysUser.mapper.SysuserMapper;
import com.peake.webseed.feature.sysUser.model.Sysuser;
import com.peake.webseed.feature.sysUser.service.SysuserService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/14.
 */
@Service
@Transactional
public class SysuserServiceImpl extends AbstractService<Sysuser> implements SysuserService {
    @Resource
    private SysuserMapper sysuserMapper;

}
