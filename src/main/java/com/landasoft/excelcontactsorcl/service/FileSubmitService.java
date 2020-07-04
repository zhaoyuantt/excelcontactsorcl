package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.common.pojo.SDMapping;
import com.landasoft.excelcontactsorcl.pojo.TFileSheet;
import com.landasoft.excelcontactsorcl.util.MyResult;

import java.util.List;
import java.util.Map;

/**
 * 文件提交Service接口
 * @author zhaoyuan
 * @date 2020,May 24 2:22 pm
 */
public interface FileSubmitService {

    MyResult getFileSheetListByFileId(String fileId);

    List<TFileSheet> getFileSheet(String fileId);

    int saveFileSheet(TFileSheet fileSheet);

    int saveFileSheet(List<TFileSheet> fileSheetList);

    /**
     * 输出excel文件内容
     * @param fileId
     * @param viewNum
     * @param layuiTransferResultList
     * @return
     */
    MyResult showViewExcel(String fileId, String viewNum,List<LayuiTransferResult> layuiTransferResultList);

    /**
     * 获取映射中源字段和目标字段
     * @param fileId
     * @return
     */
    MyResult getSourceAndDbField(String fileId);

    /**
     * 导入之前，获取导入规则
     * @param fileId
     * @param sheetList
     * @param sdMappingList
     * @return
     */
    Map<Integer,String> importBefore(String fileId, List<LayuiTransferResult> sheetList, List<SDMapping> sdMappingList);

    /**
     * 工作线程读取的插入数据库
     * @param tjMap
     * @return
     */
    int importDb(Map<String,String> tjMap);

    /**
     * 导入时开线程
     * @param sheetList
     * @param drpc
     * @param readRuleMap
     * @return
     */
    MyResult importMidele(String fileId,List<LayuiTransferResult> sheetList,String drpc,Map<Integer,String> readRuleMap);
}
