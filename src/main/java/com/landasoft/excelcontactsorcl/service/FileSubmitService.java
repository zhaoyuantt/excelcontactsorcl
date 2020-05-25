package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.util.MyResult;

/**
 * 文件提交Service接口
 * @author zhaoyuan
 * @date 2020,May 24 2:22 pm
 */
public interface FileSubmitService {

    MyResult getFileSheetListByFileId(String fileId);
}
