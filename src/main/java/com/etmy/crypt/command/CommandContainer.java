package com.etmy.crypt.command;

import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.IOFileService;

import java.util.HashMap;

public class CommandContainer {

    private final HashMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService, IOFileService ioFileService){
        commandMap = new HashMap<>();

        commandMap.put(CommandName.WELCOME.getName(),new WellcomeCommand(sendMessageService));
        commandMap.put(CommandName.NO.getName(),new NoCommand(sendMessageService));
        commandMap.put(CommandName.EXIT.getName(), new ExitCommand(sendMessageService));
        commandMap.put(CommandName.HELP.getName(), new HelpCommand(sendMessageService));
        commandMap.put(CommandName.SET_READ_PATH.getName(), new SetReadPathCommand(sendMessageService,ioFileService));
        commandMap.put(CommandName.SET_WRITE_PATH.getName(), new SetWritePathCommand(sendMessageService,ioFileService));
        commandMap.put(CommandName.ENCODE.getName(), new EncodeCommand(sendMessageService, ioFileService));
        commandMap.put(CommandName.DECODE.getName(), new DecodeCommand(sendMessageService, ioFileService));
        commandMap.put(CommandName.BRUTEFORCE.getName(), new BruteforceCommand(sendMessageService, ioFileService));
        commandMap.put(CommandName.STATIC_ANALYSIS.getName(), new StaticAnalysesCommand(sendMessageService, ioFileService));

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
