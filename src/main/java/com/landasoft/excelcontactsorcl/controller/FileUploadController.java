package com.landasoft.excelcontactsorcl.controller;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiUploadResult;
import com.landasoft.excelcontactsorcl.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件上传Controller
 * @author zhaoyuan
 * @date 2020,May 23 5:50 pm
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/showUploadPage",method = {RequestMethod.GET})
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("file_upload");
        return modelAndView;
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public LayuiUploadResult fileUpload(@RequestParam("file") MultipartFile uploadFile){
        LayuiUploadResult layuiUploadResult = fileService.saveFile(uploadFile);
        return layuiUploadResult;
    }
}
