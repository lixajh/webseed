package com.peake.webseed.feature.order.controller;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
* Created by CodeGenerator on 2018/10/07.
*/
@RestController
@RequestMapping("manager/order")
public class OrderManagerController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(OrderManagerController.class);

    @Resource
    private OrderService orderService;

//    @PostMapping("/add")
//    public Result add(Order order) {
//        orderService.save(order);
//        return ResultGenerator.genSuccessResult();
//    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        orderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Order order) {
        orderService.update(order);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        HashMap<String,Object> order = orderService.findDetailById(id);
        return ResultGenerator.genSuccessResult(order);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, HashMap<String,Object> order) {
       PageInfo pageInfo = orderService.findMapByCustomPage(page, size, order);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
