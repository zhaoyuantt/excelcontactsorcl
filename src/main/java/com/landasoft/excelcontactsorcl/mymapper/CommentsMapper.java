package com.landasoft.excelcontactsorcl.mymapper;

import com.landasoft.excelcontactsorcl.common.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据库表字段注释Mapper接口
 * @author zhaoyuan
 * @date 2020,July 2
 */
@Mapper
public interface CommentsMapper {

    public List<Comments> getTableColumnList(String tableName);
}
