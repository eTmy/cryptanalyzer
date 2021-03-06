package com.etmy.crypt.service;

public class SendMessageServiceImpl implements SendMessageService {

    private boolean isWorking = true;
    public static String DELIMITER_MESSAGE = "*****************************************";

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
        System.out.println(DELIMITER_MESSAGE);
    }

    @Override
    public void sendMessage(String message, boolean disableDelimiter) {
        System.out.println(message);
    }

    @Override
    public void stopService() {
        this.isWorking = false;
    }

    public boolean isWorking() {
        return isWorking;
    }

}
