package com.peake.webseed.feature.pay.controller;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.feature.pay.service.PayRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.List;
import com.peake.webseed.core.AbstractController;

/**
* Created by CodeGenerator on 2018/10/07.
*/
@RestController
@RequestMapping("server/pay")
public class PayRecordController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(PayRecordController.class);

    @Resource
    private PayRecordService payRecordService;

    @PostMapping("/getPayInfo")
    public Result getPayInfo(PayRecord payRecord) {
        payRecordService.save(payRecord);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        payRecordService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PayRecord payRecord) {
        payRecordService.update(payRecord);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        PayRecord payRecord = payRecordService.findById(id);
        return ResultGenerator.genSuccessResult(payRecord);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, PayRecord payRecord) {
       PageInfo pageInfo = payRecordService.findbyPage(page,size,"createTime",payRecord);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
