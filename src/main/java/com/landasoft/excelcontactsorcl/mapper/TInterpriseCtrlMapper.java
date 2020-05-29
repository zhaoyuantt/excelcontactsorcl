package com.landasoft.excelcontactsorcl.mapper;

import com.landasoft.excelcontactsorcl.pojo.TInterpriseCtrl;
import com.landasoft.excelcontactsorcl.pojo.TInterpriseCtrlExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TInterpriseCtrlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int countByExample(TInterpriseCtrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int deleteByExample(TInterpriseCtrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int deleteByPrimaryKey(String ids);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int insert(TInterpriseCtrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int insertSelective(TInterpriseCtrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    List<TInterpriseCtrl> selectByExample(TInterpriseCtrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    TInterpriseCtrl selectByPrimaryKey(String ids);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int updateByExampleSelective(@Param("record") TInterpriseCtrl record, @Param("example") TInterpriseCtrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int updateByExample(@Param("record") TInterpriseCtrl record, @Param("example") TInterpriseCtrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int updateByPrimaryKeySelective(TInterpriseCtrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_INTERPRISE_CTRL
     *
     * @mbggenerated Fri May 29 15:24:56 CST 2020
     */
    int updateByPrimaryKey(TInterpriseCtrl record);
}