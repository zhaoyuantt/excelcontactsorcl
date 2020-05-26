package com.landasoft.excelcontactsorcl.controller;

import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件提交Controller
 * @author zhaoyuan
 * @date 2020,May 24 2:25 pm
 */
@Controller
@RequestMapping("/filesubmit")
public class FileSubmitController {

    @Autowired
    private FileSubmitService fileSubmitService;

    /**
     * 跳转到文件提交页面
     * @param fileId
     * @return
     */
    @RequestMapping(value = "/page/{fileId}")
    public ModelAndView goFileSubmitPage(@PathVariable String fileId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fileId",fileId);
        modelAndView.setViewName("file_submit");
        return modelAndView;
    }

    /**
     * 获取文件sheet
     * @param fileId
     * @return
     */
    @RequestMapping(value = "/getFileSheetList/{fileId}",method = {RequestMethod.GET})
    @ResponseBody
    public MyResult getFileSheetList(@PathVariable String fileId){
        MyResult myResult = fileSubmitService.getFileSheetListByFileId(fileId);
        return myResult;
    }
}
