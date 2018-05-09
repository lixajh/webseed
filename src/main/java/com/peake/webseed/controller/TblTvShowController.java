package com.peake.webseed.controller;

import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.model.TblTvShow;
import com.peake.webseed.service.TblTvShowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.utils.DateUtils;
import com.peake.webseed.utils.PkUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/12/19.
 */
@RestController
@RequestMapping("/demo")
public class TblTvShowController {
    @Resource
    private TblTvShowService tblTvShowService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @RequestMapping("getToday")
    @ResponseBody
    public Result getToday(HttpServletRequest request) {
        TblTvShow record = tblTvShowService.getToday();


        return ResultGenerator.genSuccessResult(record);
    }

    @RequestMapping("getNewMonth")
    @ResponseBody
    public Map<String, List<String>> getList(HttpServletRequest request, String date, Integer addMonth) throws ParseException {
        if (addMonth == null) {
            addMonth = 0;
        }
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format1.parse(date);
        List<String> list = tblTvShowService.getList(date1, addMonth);
        Map<String, List<String>> returnMap = new HashMap<>();
        returnMap.put("date", list);
        return returnMap;
    }


    @RequestMapping("getDateRecord")
    @ResponseBody
    public Map<String, Object> getDateRecord(HttpServletRequest request, String date) {
        Map<String, Object> returnMap = tblTvShowService.getRecord(date);

        return returnMap;
        //		return "{\"date\":[\"2017-12-09\",\"2017-12-08\"]}";
    }

    @PostMapping("/add")
    public Result add(TblTvShow tblTvShow) {
        if (tblTvShow.getmDate()!= null){

            String dateStr = DateUtils.getDateStr(tblTvShow.getmDate());
            Map<String, Object> returnMap = tblTvShowService.getRecord(dateStr);
            if (returnMap != null && returnMap.containsKey("pk_global_id")){

                return ResultGenerator.genFailResult("dateStr"+"已存在");
            }
        }
        tblTvShow.setPkGlobalId(PkUtils.getPk());
        tblTvShow.setHaveShow(0);
        tblTvShowService.save(tblTvShow);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tblTvShowService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TblTvShow tblTvShow) {
        tblTvShowService.update(tblTvShow);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/detail")
    public Result detail(@RequestParam String id) {
        TblTvShow tblTvShow = tblTvShowService.findById(id);
        return ResultGenerator.genSuccessResult(tblTvShow);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TblTvShow> list = tblTvShowService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/dailyUpdate")
    public Result dailyUpdate() {
        tblTvShowService.enableRecordBeforeToday();
        return ResultGenerator.genSuccessResult();
    }
}
