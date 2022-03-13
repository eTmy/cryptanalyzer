package com.etmy.command;

import com.etmy.service.IOFileService;
import com.etmy.service.SendMessageService;
import java.util.HashMap;

import static com.etmy.command.CommandName.*;

public class CommandContainer {

    private final HashMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService, IOFileService ioFileService){
        commandMap = new HashMap<>();

        commandMap.put(WELCOME.getCommandName(),new WellcomeCommand(sendMessageService));
        commandMap.put(NO.getCommandName(),new NoCommand(sendMessageService));
        commandMap.put(EXIT.getCommandName(), new ExitCommand(sendMessageService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendMessageService));
        commandMap.put(SET_READ_PATH.getCommandName(), new SetReadPathCommand(sendMessageService,ioFileService));
        //commandMap.put(ENCODE.getCommandName(),new WellcomeCommand(sendMessageService));
        //commandMap.put(DECODE.getCommandName(),new WellcomeCommand(sendMessageService));
        //commandMap.put(BRUTEFORCE.getCommandName(),new WellcomeCommand(sendMessageService));
        //commandMap.put(STATIC_ANALYSIS.getCommandName(),new WellcomeCommand(sendMessageService));

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
