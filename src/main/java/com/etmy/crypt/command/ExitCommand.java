package com.etmy.crypt.command;

import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.SendMessageServiceImpl;

public class ExitCommand  implements Command{

    private final SendMessageService sendMessageService;

    private static final String EXIT_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE +"\n"
                        +"Благодарим вас за выбор сети \"АТОМКРИПТ Индастриз (ТМ)\"\n"
                        +"Вы покидаете терминал. Будьте осторожны снаружи (◕‿◕)";
    public ExitCommand (SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(String commandArg) {
        sendMessageService.sendMessage(EXIT_MESSAGE);
        sendMessageService.stopService();
    }
}
