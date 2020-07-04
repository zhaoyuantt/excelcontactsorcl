package com.landasoft.excelcontactsorcl.service;

import com.landasoft.excelcontactsorcl.common.pojo.LayuiUploadResult;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件Service接口
 * @author zhaoyuan
 * @date 2020,May 23 7:00 pm
 */
public interface FileService {

    /**
     * 将上传的文件保存到磁盘
     * @param multipartFile
     * @return
     */
    LayuiUploadResult saveFile(MultipartFile multipartFile);

    /**
     * 编辑文档对象
     * @param fileId
     * @return
     */
    MyResult updateFileById(String fileId);
}
