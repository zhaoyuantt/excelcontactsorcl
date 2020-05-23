package com.landasoft.excelcontactsorcl.service.impl;

import com.landasoft.excelcontactsorcl.mapper.TItemInfoMapper;
import com.landasoft.excelcontactsorcl.pojo.TItemInfo;
import com.landasoft.excelcontactsorcl.pojo.TItemInfoExample;
import com.landasoft.excelcontactsorcl.service.TjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service 接口实现
 * @author zhaoyuan
 * @date 2020,May 22 11:39 pm
 */
@Service
public class TjServiceImpl implements TjService {

    @Autowired
    private TItemInfoMapper itemInfoMapper;

    @Override
    public List<TItemInfo> getItemInfo() {
        TItemInfoExample example = new TItemInfoExample();
        List<TItemInfo> itemInfoList = itemInfoMapper.selectByExample(example);

        if(null == itemInfoList || 0 == itemInfoList.size()){
            return null;
        }

        return itemInfoList;
    }
}
