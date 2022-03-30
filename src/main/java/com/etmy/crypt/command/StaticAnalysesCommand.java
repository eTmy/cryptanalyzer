package com.etmy.crypt.command;

import com.etmy.crypt.service.IOFileService;
import com.etmy.crypt.service.SendMessageService;

public class StaticAnalysesCommand implements Command{
    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public StaticAnalysesCommand (SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage("Станет доступно в будущих версиях проекта. Наберитесь терпения ( ˘︹˘ )");
    }
}
