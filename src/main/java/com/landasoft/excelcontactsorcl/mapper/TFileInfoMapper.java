package com.landasoft.excelcontactsorcl.mapper;

import com.landasoft.excelcontactsorcl.pojo.TFileInfo;
import com.landasoft.excelcontactsorcl.pojo.TFileInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TFileInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int countByExample(TFileInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int deleteByExample(TFileInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int insert(TFileInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int insertSelective(TFileInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    List<TFileInfo> selectByExample(TFileInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") TFileInfo record, @Param("example") TFileInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_FILE_INFO
     *
     * @mbggenerated Sat May 23 19:03:58 CST 2020
     */
    int updateByExample(@Param("record") TFileInfo record, @Param("example") TFileInfoExample example);
}