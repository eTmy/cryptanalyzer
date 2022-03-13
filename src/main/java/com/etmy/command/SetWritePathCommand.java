package com.etmy.command;

import com.etmy.io.IO;
import com.etmy.service.IOFileService;
import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

public class SetWritePathCommand implements Command{

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public static final String SET_WRITE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Установлен следующий путь записи файла: ";
    public static final String CANT_CREATE_FILE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Невозможно создать файл с указанным путем: ";


    public SetWritePathCommand(SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {

        if (IO.canCreateFile(commandArg)){
            ioFileService.setWritePath(commandArg);
            sendMessageService.sendMessage(SET_WRITE_MESSAGE + commandArg);
        } else {
            sendMessageService.sendMessage(CANT_CREATE_FILE_MESSAGE + commandArg);
        }

    }
}
