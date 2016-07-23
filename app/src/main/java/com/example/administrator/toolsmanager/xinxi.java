package com.example.administrator.toolsmanager;

/**
 * Created by Administrator on 2016/6/24.
 */
public class xinxi {
    private String name;
    private String code;
    private int in;
    private int fei;

    public xinxi(String name,String code,int in,int fei) {
        this.name=name;
        this.code=code;
        this.in=in;
        this.fei=fei;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public void setFei(int fei) {
        this.fei = fei;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getIn() {
        return in;
    }

    public int getFei() {
        return fei;
    }
}
