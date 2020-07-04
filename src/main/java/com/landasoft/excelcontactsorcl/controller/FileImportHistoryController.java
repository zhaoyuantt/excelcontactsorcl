package com.landasoft.excelcontactsorcl.controller;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiTableResult;
import com.landasoft.excelcontactsorcl.pojo.TFileImportHistory;
import com.landasoft.excelcontactsorcl.service.FileImportHistoryService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件导入历史Controller
 * @author zhaoyuan
 * @date 2020,July 4 11:05 pm
 */
@Controller
@RequestMapping("/file/history")
public class FileImportHistoryController {

    @Autowired
    private FileImportHistoryService fileImportHistoryService;

    @RequestMapping("/page")
    public ModelAndView showHistoryPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("file_history");
        return modelAndView;
    }

    @RequestMapping("/getFileImportHistory")
    @ResponseBody
    public LayuiTableResult getFileImportHistory(TFileImportHistory fileImportHistory,Integer page,Integer limit){
        LayuiTableResult layuiTableResult = fileImportHistoryService.getFileImportHistory(fileImportHistory, page, limit);
        return layuiTableResult;
    }

    /**
     *
     * @param historyId
     * @param category
     * @return
     */
    @RequestMapping("/delete/{historyId}/{category}")
    @ResponseBody
    public MyResult deleteFileImportData(@PathVariable String historyId,@PathVariable String category){
        MyResult myResult = fileImportHistoryService.deleteFileImportDataByHidAndCategory(historyId, category);
        return myResult;
    }


}
