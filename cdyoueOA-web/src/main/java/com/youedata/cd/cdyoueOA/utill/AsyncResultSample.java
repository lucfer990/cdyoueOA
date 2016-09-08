package com.youedata.cd.cdyoueOA.utill;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public class AsyncResultSample extends AbstractAsyncResult {
    private String message;
    private int status;
    private Map<String,Object> data = new HashMap<String,Object>();

    public AsyncResultSample() {
        this.status = HttpStatus.OK.value();
        this.message= "成功";
    }

    public AsyncResultSample(HttpStatus status,String message) {
        this.status = status.value();
        this.message= message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AsyncResultSample(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public void putData(String key, Object value) {
        this.data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getStatus() {
        return this.status;
    }
}
