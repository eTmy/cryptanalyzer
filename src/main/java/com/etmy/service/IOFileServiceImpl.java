package com.etmy.service;

public class IOFileServiceImpl implements IOFileService{

    private String readPath, loadPath;


    @Override
    public void setReadPath(String readPath) {
        this.readPath = readPath;
    }

    @Override
    public void setLoadPath(String loadPath) {
        this.loadPath = loadPath;
    }

    public String getReadPath() {
        return readPath;
    }

    public String getLoadPath() {
        return loadPath;
    }
}
