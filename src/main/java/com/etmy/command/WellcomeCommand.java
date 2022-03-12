package com.etmy.command;

import com.etmy.service.SendMessageService;

import static com.etmy.command.CommandName.*;

public class WellcomeCommand implements Command{

    private final SendMessageService sendMessageService;

    public WellcomeCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    public static final String WELCOME_MESSAGE =
            String.format("*****************************************\n"
                            +"Добро пожаловать в сеть \" АТОМКРИПТ Индастриз (ТМ)\" ＼(￣▽￣)／\n"
                            +"Вас приветствует терминал криптоанализа:\n"
                            +"  %s - Узнать список команд\n"
                            +"  %s - Завершить текущую сессию\n"
                            +"*****************************************",
                    HELP.getCommandName(),EXIT.getCommandName());

    @Override
    public void execute() {
        try {
            sendMessageService.sendMessage("Инициализируем окружение ..");
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем песочницу для защиты информации ..");
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем ключи шифрования данных ..");
            Thread.sleep(1000);
            sendMessageService.sendMessage("Создаем криптографические абстракции ..");
            Thread.sleep(1000);
            sendMessageService.sendMessage("Генерируем ключи рукопожатия ..");
            Thread.sleep(1000);
            sendMessageService.sendMessage(WELCOME_MESSAGE);
        } catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }
    }
}
