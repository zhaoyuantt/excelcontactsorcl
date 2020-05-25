package com.landasoft.excelcontactsorcl.service.impl;

import com.landasoft.excelcontactsorcl.mapper.TFileInfoMapper;
import com.landasoft.excelcontactsorcl.mypojo.LayuiTransferResult;
import com.landasoft.excelcontactsorcl.pojo.TFileInfo;
import com.landasoft.excelcontactsorcl.pojo.TFileInfoExample;
import com.landasoft.excelcontactsorcl.service.FileSubmitService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件提交Service接口实现
 * @author zhaoyuan
 * @date 2020,May 24 2:23 pm
 */
@Service
public class FileSubmitServiceImpl implements FileSubmitService {

    private static final Logger log = Logger.getLogger(FileSubmitServiceImpl.class);

    @Autowired
    private TFileInfoMapper fileInfoMapper;

    @Override
    public MyResult getFileSheetListByFileId(String fileId) {
        if(StringUtils.isBlank(fileId)){
            throw new RuntimeException("文件Id为blank");
        }

        //结果容器
        Map<Object,String> map = new HashMap<Object, String>();
        LayuiTransferResult layuiTransferResult = new LayuiTransferResult();
        List<Map<Object,String>> list = new ArrayList<Map<Object, String>>();

        TFileInfoExample example = new TFileInfoExample();
        TFileInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(fileId);
        List<TFileInfo> fileInfoList = fileInfoMapper.selectByExample(example);

        //没有查询到记录
        if(null == fileInfoList || 0 == fileInfoList.size()){
            return MyResult.build(501,"数据库查询异常");
        }

        TFileInfo fileInfo = fileInfoList.get(0);
        String filePath = fileInfo.getFilePath().replace("\\","/");
        log.info("获取sheet时，文件的存储路径");

        //获取Sheet
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            int sheetNumbers = workbook.getNumberOfSheets();

            for(int i = 0 ;i < sheetNumbers;i++){
                XSSFSheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                map.put(i,sheetName);
            }

            list.add(map);

            layuiTransferResult.setData(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return MyResult.ok(layuiTransferResult);
    }
}
