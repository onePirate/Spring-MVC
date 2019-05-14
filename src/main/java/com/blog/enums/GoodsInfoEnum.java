package com.blog.enums;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/20 14:37
 */
public enum GoodsInfoEnum {

    PROPERTY1(0,"goodsCode"),
    PROPERTY2(1,"internationalCode"),
    PROPERTY3(2,"goodsName"),
    PROPERTY4(3,"name");

    GoodsInfoEnum(Integer index, String property) {
        this.index = index;
        this.property = property;
    }

    private Integer index;
    private String property;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
