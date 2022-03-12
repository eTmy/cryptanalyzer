package com.etmy.command;

import com.etmy.service.SendMessageService;

public class ExitCommand  implements Command{

    private final SendMessageService sendMessageService;

    private static final String EXIT_MESSAGE = "*****************************************\n"
                        +"Благодарим вас за выбор сети \"АТОМКРИПТ Индастриз (ТМ)\"\n"
                        +"Вы покидаете терминал. Будьте осторожны снаружи (◕‿◕)\n"
                        +"*****************************************";
    public ExitCommand (SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute() {
        sendMessageService.sendMessage(EXIT_MESSAGE);
        sendMessageService.stopService();
    }
}
