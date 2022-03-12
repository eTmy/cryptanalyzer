package com.etmy.command;

import com.etmy.service.SendMessageService;

public class NoCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String NO_MESSAGE = "*****************************************\n"
                        +"Я поддерживаю команды, начинающиеся со слеша (/). \n"
                        + "Чтобы посмотреть список команд введите /help\n"
                        +"*****************************************";

    public NoCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute() {
        sendMessageService.sendMessage(NO_MESSAGE);
    }
}
