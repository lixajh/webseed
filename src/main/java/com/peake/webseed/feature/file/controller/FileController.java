package com.peake.webseed.feature.file.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.utils.CodeUtils;
import com.peake.webseed.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
* Created by CodeGenerator on 2018/09/05.
*/
@RestController
@RequestMapping("/file")
public class FileController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${file.savePath}")
    private String uploadPath;
    @Value("${file.accessPath}")
    private String accessPath;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
        String suffix = "";
        String[] split = file.getOriginalFilename().split("\\.");
        if (split.length > 1){
            suffix = split[split.length - 1];
        }
        String newName = CodeUtils.genPicName()+"." + suffix;
        try {
            byte[] bytes = file.getBytes();
            FileUtil.uploadFile(bytes, uploadPath, newName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultGenerator.genSuccessResult(accessPath+newName);
    }
}
