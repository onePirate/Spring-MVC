package com.blog.enums;

/**
 * @function: 定义全局错误返回状态
 * @Author: gaodawei
 * @Date: 2018/1/16 16:37
 */
public enum StateEnum {

    STATE_200(200,"正常"),
    STATE_201(201,"已过期"),
    STATE_202(202,"被迫下线"),
    STATE_500(500,"请求出错"),
    ;

    private Integer state;
    private String desc;

    StateEnum(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
