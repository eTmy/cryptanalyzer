package com.etmy.command;

import com.etmy.cryptology.Cryptology;
import com.etmy.io.IO;
import com.etmy.service.IOFileService;
import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
