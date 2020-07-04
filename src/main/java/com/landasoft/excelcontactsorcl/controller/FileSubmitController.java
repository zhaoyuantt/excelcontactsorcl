package com.landasoft.excelcontactsorcl.controller;

import com.alibaba.fastjson.JSONObject;
import com.landasoft.excelcontactsorcl.common.pojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.common.pojo.SDMapping;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * excel预览
     * @param fileId
     * @param viewNum
     * @param sheetData_transfer
     * @return
     */
    @RequestMapping(value = "/viewExcel",method = RequestMethod.POST)
    @ResponseBody
    public MyResult showViewExcel(String fileId, String viewNum, String sheetData_transfer){
        //在这里判断sheet是否为空
        if(StringUtils.isBlank(sheetData_transfer)){
            throw new RuntimeException("Must param sheetData_transfer is null!");
        }
        List<LayuiTransferResult> yList = new ArrayList<LayuiTransferResult>();
        //将sheetData_transfer转为List<LayuiTransferResult>
        List<JSONObject> list = JSONObject.parseObject(sheetData_transfer,List.class);
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject =  list.get(i);
            LayuiTransferResult layuiTransferResult = new LayuiTransferResult();
            String title = jsonObject.get("title").toString();
            layuiTransferResult.setTitle(title);
            yList.add(layuiTransferResult);
        }
        MyResult myResult = fileSubmitService.showViewExcel(fileId, viewNum, yList);
        return myResult;
    }

    /**
     * 获取映射中源字段和目标字段
     * @param fileId
     * @return
     */
    @RequestMapping("/getSDfield/{fileId}")
    @ResponseBody
    public MyResult getSourceAndDBFieldList(@PathVariable String fileId){
        MyResult myResult = fileSubmitService.getSourceAndDbField(fileId);
        return myResult;
    }

    /**
     * 导入提交
     * @param fileId
     * @param drpc
     * @param is_space
     * @param transferData
     * @param mappingListS
     * @return
     */
    @RequestMapping(value = "/doS",method = RequestMethod.POST)
    @ResponseBody
    public MyResult doSubmit(String fileId,String drpc, String is_space, String transferData, String mappingListS){
        System.out.println("===========");
        System.out.println("fileId:"+fileId);
        System.out.println("drpc:"+drpc);
        System.out.println("is_space:"+is_space);
        System.out.println("transferData:"+transferData);
        System.out.println("mappingListS:"+mappingListS);
        System.out.println("===========");

        List<LayuiTransferResult> sheetList = null;
        List<SDMapping> sdMappingList = null;

        try {
            //将transferData转为List<LayuiTransferResult>
            sheetList = JSONObject.parseArray(transferData, LayuiTransferResult.class);

            //将mappingListS转为List<SDMapping>
            sdMappingList = JSONObject.parseArray(mappingListS, SDMapping.class);
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.build(800,"Json parse is error!");
        }

        //获取导入规则
        Map<Integer, String> readRuleMap = fileSubmitService.importBefore(fileId, sheetList, sdMappingList);

        MyResult myResult = fileSubmitService.importMidele(fileId, sheetList, drpc, readRuleMap);

        return myResult;
    }

}
