package com.etmy.crypt.service;

public interface SendMessageService {

    void sendMessage(String message);

    void sendMessage(String message, boolean disableDelimiter);

    void stopService();

}
