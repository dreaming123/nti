package com.jcz.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
  @Component
public class Rest_M<T> {
    private   boolean success=false;//是否成功
    private  String  msg;// 返回的说明
    private   int pageNum;  //第几页
    private   int pageSize;  //分页的大小
    private List<T>  data; //返回的数据

    public boolean isSuccess() {
        return success;
    }

    public Rest_M<T> setSuccess(boolean success) {
        this.success = success;

        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Rest_M<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getPageNum() {
        return pageNum;
    }

    public Rest_M<T> setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Rest_M<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public Rest_M<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
