package com.etmy.command;

import com.etmy.service.SendMessageService;

public class UnknownCommand implements Command{

    public static final String UNKNOWN_MESSAGE = "\nНе понимаю вас ¯\\_(ツ)_/¯ напишите /help чтобы узнать, что я смогу понять\n";

    public final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute() {
        sendMessageService.sendMessage(UNKNOWN_MESSAGE);
    }
}
