package com.etmy.command;

import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

import static com.etmy.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendMessageService sendMessageService;

    private final String HELP_MESSAGE =
            String.format(SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                            +"Настройка файла:\n"

                            +"  %s + путь к файлу - Установить путь загрузки файла\n"
                            +"  %s + путь к файлу - Установить путь выгрузки файла\n"

                            +"Операции с файлом:\n"

                            +"  %s + количество сдвигаемых символов - зашифровать\n"
                            +"  %s - расшифровать с помощью ключа\n"
                            +"  %s - расшифровать с помощью bruteforce\n"
                            +"  %s - расшифровать с помощью синтаксического анализа",

                    SET_READ_PATH.getCommandName(),SET_WRITE_PATH.getCommandName(),
                    ENCODE.getCommandName(),DECODE.getCommandName(),
                    BRUTEFORCE.getCommandName(),STATIC_ANALYSIS.getCommandName(),
                    HELP.getCommandName());

    public HelpCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage(HELP_MESSAGE);
    }
}
