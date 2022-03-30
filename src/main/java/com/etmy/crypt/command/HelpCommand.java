package com.etmy.crypt.command;

import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.SendMessageServiceImpl;

public class HelpCommand implements Command{

    private static final String HELP_MESSAGE =
            String.format(SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                            +"Настройка файла:\n"

                            +"  %s + путь к файлу - Установить путь загрузки файла\n"
                            +"  %s + путь к файлу - Установить путь выгрузки файла\n"

                            +"Операции с файлом:\n"

                            +"  %s + количество сдвигаемых символов - зашифровать\n"
                            +"  %s - расшифровать с помощью ключа\n"
                            +"  %s - расшифровать с помощью bruteforce\n"
                            +"  %s - расшифровать с помощью синтаксического анализа",

                    CommandName.SET_READ_PATH.getName(), CommandName.SET_WRITE_PATH.getName(),
                    CommandName.ENCODE.getName(), CommandName.DECODE.getName(),
                    CommandName.BRUTEFORCE.getName(), CommandName.STATIC_ANALYSIS.getName(),
                    CommandName.HELP.getName());

    private final SendMessageService sendMessageService;

    public HelpCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage(HELP_MESSAGE);
    }
}
