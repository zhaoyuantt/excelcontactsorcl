package com.landasoft.excelcontactsorcl.constant;

/**
 * 系统模块分类常量枚举类
 * @author zhaoyuan
 * @date 2020,July 6 3:20 pm
 */
public enum CategoryConstant {

    ITEM_INFO("item_info","商品基本信息");

    String code;
    String name;

    CategoryConstant(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String code){
        for(CategoryConstant evenEnum : CategoryConstant.values()){
            if(evenEnum.getCode().equals(code)){
                return evenEnum.getName();
            }
        }
        return null;
    }
}
