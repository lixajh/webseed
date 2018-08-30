package com.peake.webseed.feature.member.service.impl;

import com.peake.webseed.feature.member.mapper.MemberMapper;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MemberServiceImpl extends AbstractService<Member> implements MemberService {

    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper MemberMapper;

}
