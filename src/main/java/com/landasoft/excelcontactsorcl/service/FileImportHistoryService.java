package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiTableResult;
import com.landasoft.excelcontactsorcl.pojo.TFileImportHistory;
import com.landasoft.excelcontactsorcl.util.MyResult;

/**
 * 文件导入历史Service接口实现
 * @author zhaoyuan
 * @date 2020,July 4 10:34 pm
 */
public interface FileImportHistoryService {

    /**
     *
     * @param fileImportHistory 查询条件
     * @param pageNum 当前页
     * @param pageSize 每页显示多少条数据
     * @return
     */
    LayuiTableResult getFileImportHistory(TFileImportHistory fileImportHistory, Integer pageNum, Integer pageSize);

    /**
     * 删除某个文件的所有导入文档记录
     * @param historyId
     * @param category
     * @return
     */
    MyResult deleteFileImportDataByHidAndCategory(String historyId,String category);
}
