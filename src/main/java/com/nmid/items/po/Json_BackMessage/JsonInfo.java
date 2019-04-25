package com.nmid.items.po.Json_BackMessage;

import java.util.HashMap;
import java.util.Map;

public class JsonInfo {
    private int status;

    private String message;

    private Map<String,Object> BeanList = new HashMap<String, Object>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getBeanList() {
        return BeanList;
    }

    public void setBeanList(Map beanList) {
        BeanList = beanList;
    }
    public static JsonInfo success(){
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("操作成功");
        return  jsonInfo;
    }
    public static JsonInfo fail(){
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(500);
        jsonInfo.setMessage("操作失败");
        return jsonInfo;
    }
    public  JsonInfo add(String key,Object value){
        this.getBeanList().put(key,value);
        return this;
    }
}
