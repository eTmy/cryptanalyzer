package com.etmy.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class IOFileServiceImpl implements IOFileService{

    private String readPath, writePath;

    @Override
    public void setReadPath(String readPath) {
        this.readPath = readPath;
    }

    @Override
    public void setWritePath(String loadPath) {
        this.writePath = loadPath;
    }

    public String getReadPath() {
        return readPath;
    }

    public String getWritePath() {
        return writePath;
    }


}
