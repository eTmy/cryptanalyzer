package com.etmy.crypt.command;

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
    STATIC_ANALYSIS("/staticanalysis");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getName(){
        return commandName;
    }
}
