package com.etmy.command;

public enum CommandName {
    WELCOME("/start"),
    EXIT("/exit"),
    NO("nocommand"),
    HELP("/help"),
    SET_READ_PATH("/setreadpath"),
    SET_WRITE_PATH("/setwritepath"),
    ENCODE("/encode"),
    DECODE("/decode"),
    BRUTEFORCE("/bruteforce"),
    STATIC_ANALYSIS("/staticAnalysis");

    ;

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
