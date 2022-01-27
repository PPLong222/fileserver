package com.pplong.fileserver.pojo;

import com.pplong.fileserver.util.FileUtils;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class SingleFile {
    private String name;
    private long size;
    private long time;
    private String location;

    public SingleFile(String name, long size, long time, String location) {
        this.name = name;
        this.size = size;
        this.time = time;
        this.location = location;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
