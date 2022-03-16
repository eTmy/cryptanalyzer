package com.etmy.command;

import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

import static com.etmy.command.CommandName.*;

public class WellcomeCommand implements Command{

    private final SendMessageService sendMessageService;

    public WellcomeCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    public static final String WELCOME_MESSAGE =
            String.format(SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
                            +"Добро пожаловать в сеть \" АТОМКРИПТ Индастриз (ТМ)\" ＼(￣▽￣)／\n"
                            +"Вас приветствует терминал криптоанализа:\n"
                            +"  %s - Узнать список команд\n"
                            +"  %s - Завершить текущую сессию",
                    HELP.getCommandName(),EXIT.getCommandName());

    @Override
    public void execute(String commandArg) {
        try {
            sendMessageService.sendMessage("Инициализируем окружение ..", true);
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем песочницу для защиты информации ..",true);
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем ключи шифрования данных ..",true );
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем криптографические абстракции ..",true);
            Thread.sleep(1000);
            sendMessageService.sendMessage("Генерируем ключи рукопожатия ..",true );
            Thread.sleep(1000);
            sendMessageService.sendMessage(WELCOME_MESSAGE);
        } catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }
    }
}
