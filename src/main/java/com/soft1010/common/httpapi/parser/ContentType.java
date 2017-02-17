package com.soft1010.common.httpapi.parser;

/**
 * @Author zhangjifu
 * @Create time: 2016/11/9 14:36
 * @Description:
 */
public enum ContentType {

    JSON("JSON", "application/json"),
    URLENCODED("URLENCODED", "application/x-www-form-urlencoded");

    private ContentType(String type, String value) {
        this.type = type;
        this.value = value;
    }

    private String value;
    private String type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
