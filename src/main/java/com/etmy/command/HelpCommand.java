package com.etmy.command;

import com.etmy.service.SendMessageService;

import static com.etmy.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendMessageService sendMessageService;

    private final String HELP_MESSAGE =
            String.format("*****************************************\n"
                            +"Настройка файла:\n"

                            +"  %s - Установить путь загрузки файла\n"
                            +"  %s - Установить путь выгрузки файла\n"

                            +"Операции с файлом:\n"

                            +"  %s - зашифровать\n"
                            +"  %s - расшифровать с помощью ключа\n"
                            +"  %s - расшифровать с помощью bruteforce\n"
                            +"  %s - расшифровать с помощью синтаксического анализа\n"
                            +"*****************************************",

                    SET_READ_PATH.getCommandName(),SET_WRITE_PATH.getCommandName(),
                    ENCODE.getCommandName(),DECODE.getCommandName(),
                    BRUTEFORCE.getCommandName(),STATIC_ANALYSIS.getCommandName(),
                    HELP.getCommandName());

    public HelpCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute() {
        sendMessageService.sendMessage(HELP_MESSAGE);
    }
}
