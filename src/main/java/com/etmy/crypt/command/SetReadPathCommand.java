package com.etmy.crypt.command;

import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.IOFileService;
import com.etmy.crypt.io.IO;
import com.etmy.crypt.service.SendMessageServiceImpl;

public class SetReadPathCommand implements Command{

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public static final String SET_READ_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                        +"Установлен следующий путь загрузки файла: ";
    public static final String FILE_NOT_FOUND_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                        +"Не удалось найти файл по указанному пути: ";


    public SetReadPathCommand(SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        if (IO.fileExists(commandArg)){
            ioFileService.setReadPath(commandArg);
            sendMessageService.sendMessage(SET_READ_MESSAGE + commandArg);
        } else sendMessageService.sendMessage(FILE_NOT_FOUND_MESSAGE + commandArg);
    }


}
