package com.etmy.crypt.command;

import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.SendMessageServiceImpl;

public class NoCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String NO_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                        +"Я поддерживаю команды, начинающиеся со слеша (/). \n"
                        + "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage(NO_MESSAGE);
    }
}
