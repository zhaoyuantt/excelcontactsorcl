package com.landasoft.excelcontactsorcl.service.impl;

import com.landasoft.excelcontactsorcl.mapper.TFileInfoMapper;
import com.landasoft.excelcontactsorcl.common.pojo.LayuiUploadResult;
import com.landasoft.excelcontactsorcl.pojo.TFileInfo;
import com.landasoft.excelcontactsorcl.service.FileService;
import com.landasoft.excelcontactsorcl.util.FileUtils;
import com.landasoft.excelcontactsorcl.util.IDUtils;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    @Transactional
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
        String id = IDUtils.getGeneId();

        TFileInfo fileInfo = new TFileInfo();
        fileInfo.setId(id);
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
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("id",id);
        layuiUploadResult.setData(map);

        return layuiUploadResult;
    }

    @Override
    @Transactional
    public MyResult updateFileById(String fileId) {
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("Required parameter is blank");
        }

        TFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
        if(null == fileInfo){
            return null;
        }

        fileInfo.setRemark("aaabbbccc");

        int uResult = fileInfoMapper.updateByPrimaryKey(fileInfo);

        return MyResult.ok();
    }
}
