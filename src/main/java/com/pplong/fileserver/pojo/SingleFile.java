package com.pplong.fileserver.pojo;

import com.pplong.fileserver.util.FileUtils;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class SingleFile {
    private String name;
    private long size;
    private long time;
    private String originName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public SingleFile(String name, String originName, long size, long time) {
        this.name = name;
        this.size = size;
        this.time = time;
        this.originName = originName;
    }
}
