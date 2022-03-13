package com.etmy.command;

import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

public class UnknownCommand implements Command{

    public static final String UNKNOWN_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                        +"Не понимаю вас ¯\\_(ツ)_/¯ напишите /help чтобы узнать, что я смогу понять";

    public final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage(UNKNOWN_MESSAGE);
    }
}
