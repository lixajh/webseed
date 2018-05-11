package com.peake.webseed.sysUser.service.impl;

import com.peake.webseed.sysUser.mapper.SysuserMapper;
import com.peake.webseed.sysUser.model.Sysuser;
import com.peake.webseed.sysUser.service.SysuserService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/11.
 */
@Service
@Transactional
public class SysuserServiceImpl extends AbstractService<Sysuser> implements SysuserService {
    @Resource
    private SysuserMapper sysuserMapper;

}
