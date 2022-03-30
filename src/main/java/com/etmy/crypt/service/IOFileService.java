package com.etmy.crypt.service;

public interface IOFileService {

    void setReadPath(String readPath);

    void setWritePath(String writePath);

    String getReadPath();

    String getWritePath();

}
