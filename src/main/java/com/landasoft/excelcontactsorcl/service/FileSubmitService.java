package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.pojo.TFileSheet;
import com.landasoft.excelcontactsorcl.util.MyResult;

import java.util.List;

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
}
