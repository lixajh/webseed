package com.peake.webseed.feature.product.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.product.enums.EnumProductDataStatus;
import com.peake.webseed.feature.product.model.Product;
import com.peake.webseed.feature.product.service.ProductService;
import com.peake.webseed.utils.VerifyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/09/12.
 */
@RestController

@RequestMapping("/manager/product")
public class ProductController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @PostMapping("/add")
    public Result add(Product product) {
        if (!VerifyUtils.verifyAllParamsNotNull(product.getTitle(),product.getName(),product.getPrice())){
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
            productService.add(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.del.getValue());
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/startSell")
    public Result startSell(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.saling.getValue());
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/stopSell")
    public Result stopSell(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.not_sale.getValue());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Product product) {
        productService.update(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Product product = productService.findById(id);
        return ResultGenerator.genSuccessResult(product);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Product product) {
        PageInfo pageInfo = productService.findbyPage(page,size,"createTime",product);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
