package com.landasoft.excelcontactsorcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件提交Controller
 * @author zhaoyuan
 * @date 2020,May 24 2:25 pm
 */
@Controller
@RequestMapping("/filesubmit")
public class FileSubmitController {

    /**
     * 跳转到文件提交页面
     * @param fileId
     * @return
     */
    @RequestMapping(value = "/page/{fileId}")
    public ModelAndView goFileSubmitPage(@PathVariable String fileId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("file_submit");
        return modelAndView;
    }
}
