package com.landasoft.excelcontactsorcl.service.impl;

import com.landasoft.excelcontactsorcl.mapper.TFileInfoMapper;
import com.landasoft.excelcontactsorcl.mypojo.LayuiUploadResult;
import com.landasoft.excelcontactsorcl.pojo.TFileInfo;
import com.landasoft.excelcontactsorcl.service.FileService;
import com.landasoft.excelcontactsorcl.util.FileUtils;
import com.landasoft.excelcontactsorcl.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 文件Service接口实现
 * @author zhaoyuan
 * @date 2020,May 23 7:07 pm
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private TFileInfoMapper fileInfoMapper;

    @Value("${FILE_STORAGE_DIR}")
    private String FILE_STORAGE_DIR;

    @Override
    public LayuiUploadResult saveFile(MultipartFile multipartFile) {
        LayuiUploadResult layuiUploadResult = new LayuiUploadResult();

        if(null == multipartFile){
            //上传失败
            layuiUploadResult.setCode(1);
            layuiUploadResult.setMsg("MultipartFile is null");

            return layuiUploadResult;
        }

        String newFilename = "";

        try {
            newFilename = FileUtils.copyFile(multipartFile, FILE_STORAGE_DIR);
        } catch (IOException e) {
            e.printStackTrace();
            layuiUploadResult.setCode(1);
            layuiUploadResult.setMsg("IOException");
            return layuiUploadResult;
        }

        String filename = multipartFile.getOriginalFilename();

        TFileInfo fileInfo = new TFileInfo();
        fileInfo.setId(IDUtils.getGeneId());
        fileInfo.setFileName(filename);
        fileInfo.setFileType(filename.substring(filename.lastIndexOf(".")).replace(".",""));
        fileInfo.setFileAlias(newFilename);
        fileInfo.setFilePath(FILE_STORAGE_DIR+"\\"+newFilename);
        fileInfo.setFileSize(BigDecimal.valueOf(multipartFile.getSize()));
        fileInfo.setRemark("taojie");
        fileInfo.setCreated(new Date());
        fileInfo.setUpdated(new Date());

        int iResult = fileInfoMapper.insert(fileInfo);

        if(1 != iResult){
            layuiUploadResult.setCode(1);
            layuiUploadResult.setMsg("未知错误");
            return layuiUploadResult;
        }

        layuiUploadResult.setCode(0);

        return layuiUploadResult;
    }
}
