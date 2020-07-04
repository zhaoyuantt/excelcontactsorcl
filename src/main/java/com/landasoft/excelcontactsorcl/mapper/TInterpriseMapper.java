package com.landasoft.excelcontactsorcl.mapper;

import com.landasoft.excelcontactsorcl.pojo.TInterprise;
import com.landasoft.excelcontactsorcl.pojo.TInterpriseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TInterpriseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int countByExample(TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int deleteByExample(TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int insert(TInterprise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int insertSelective(TInterprise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    List<TInterprise> selectByExampleWithBLOBs(TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    List<TInterprise> selectByExample(TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    TInterprise selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") TInterprise record, @Param("example") TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") TInterprise record, @Param("example") TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByExample(@Param("record") TInterprise record, @Param("example") TInterpriseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByPrimaryKeySelective(TInterprise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(TInterprise record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE
     *
     * @mbggenerated Thu Jun 04 15:30:25 CST 2020
     */
    int updateByPrimaryKey(TInterprise record);
}