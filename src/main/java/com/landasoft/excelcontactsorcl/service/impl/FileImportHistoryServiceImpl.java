package com.landasoft.excelcontactsorcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.landasoft.excelcontactsorcl.common.pojo.LayuiTableResult;
import com.landasoft.excelcontactsorcl.config.SpringContextUtils;
import com.landasoft.excelcontactsorcl.constant.CategoryConstant;
import com.landasoft.excelcontactsorcl.mapper.TFileImportHistoryMapper;
import com.landasoft.excelcontactsorcl.mapper.TItemInfoMapper;
import com.landasoft.excelcontactsorcl.pojo.TFileImportHistory;
import com.landasoft.excelcontactsorcl.pojo.TFileImportHistoryExample;
import com.landasoft.excelcontactsorcl.pojo.TItemInfoExample;
import com.landasoft.excelcontactsorcl.service.FileImportHistoryService;
import com.landasoft.excelcontactsorcl.util.MyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件导入历史Service接口实现
 * @author zhaoyuan
 * @date 2020,July 4 22:38 pm
 */
@Service
public class FileImportHistoryServiceImpl implements FileImportHistoryService {

    @Autowired
    private TFileImportHistoryMapper fileImportHistoryMapper;

    @Override
    public LayuiTableResult getFileImportHistory(TFileImportHistory fileImportHistory, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        TFileImportHistoryExample example = new TFileImportHistoryExample();
        //TODO 处理查询条件

        List<TFileImportHistory> fileImportHistoryList = fileImportHistoryMapper.selectByExample(example);

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        if(null == fileImportHistoryList || 0 == fileImportHistoryList.size()){
            layuiTableResult.setData(fileImportHistoryList);
            layuiTableResult.setCount(0);
            return layuiTableResult;
        }

        int count = fileImportHistoryMapper.countByExample(example);

        //PageInfo<TFileImportHistory> pageInfo = new PageInfo<>(fileImportHistoryList);

        layuiTableResult.setData(fileImportHistoryList);
        layuiTableResult.setCount(count);

        return layuiTableResult;
    }

    @Override
    public MyResult deleteFileImportDataByHidAndCategory(String historyId, String category) {
        if(StringUtils.isBlank(historyId)){
            throw new RuntimeException("Must param history id is null!");
        }
        if(StringUtils.isBlank(category)){
            throw new RuntimeException("Must param catagory is null!");
        }

        TFileImportHistoryExample example = new TFileImportHistoryExample();
        TFileImportHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(historyId);
        criteria.andCatagoryEqualTo(category);

        List<TFileImportHistory> fileImportHistoryList = fileImportHistoryMapper.selectByExample(example);

        if(null == fileImportHistoryList || 0 == fileImportHistoryList.size()){
            return MyResult.build(101,"No record was found according to historyId and category！");
        }

        TFileImportHistory fileImportHistory = fileImportHistoryList.get(0);

        int dhResult = fileImportHistoryMapper.deleteByExample(example);

        String fileId = fileImportHistory.getFileId();

        int diResult = 0;
        if(CategoryConstant.getName("item_info").equals(category)){
            TItemInfoMapper itemInfoMapper = SpringContextUtils.getBean(TItemInfoMapper.class);

            TItemInfoExample exampleItem = new TItemInfoExample();
            TItemInfoExample.Criteria criteriaI = exampleItem.createCriteria();
            criteriaI.andFileIdEqualTo(fileId);

            diResult = itemInfoMapper.deleteByExample(exampleItem);
        }

        if(0 == dhResult || 0 == diResult){
            return MyResult.build(102,"Db delete is not success！");
        }

        return MyResult.ok(diResult);
    }
}
