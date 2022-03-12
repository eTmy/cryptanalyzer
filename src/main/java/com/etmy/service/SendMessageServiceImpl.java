package com.etmy.service;

public class SendMessageServiceImpl implements SendMessageService {

    private boolean isWorking = true;

    @Override
    public void sendMessage(String message) {
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
