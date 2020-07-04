package com.landasoft.excelcontactsorcl.controller;

import com.landasoft.excelcontactsorcl.service.FileService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件相关Controller
 * @date 2020,June 6 2:01 pm
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/updateFileById/{fileId}")
    @ResponseBody
    public MyResult updateFileById(@PathVariable String fileId){
        MyResult myResult = fileService.updateFileById(fileId);
        return myResult;
    }
}
