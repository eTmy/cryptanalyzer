package com.etmy.dialogue;

import com.etmy.command.CommandContainer;
import com.etmy.service.IOFileServiceImpl;
import com.etmy.service.SendMessageServiceImpl;
import java.util.Scanner;

import static com.etmy.command.CommandName.*;

public class Dialogue {
//        static{
//
////        System.out.println("Добро пожаловать в сеть \" АТОМКРИПТ Индастриз (ТМ)\"");
////        System.out.println("Инициализируем окружение ..");
////        System.out.println("Создаем песочницу для защиты информации ..");
////        System.out.println("Создаем ключи шифрования данных ..");
////        System.out.println("Создаем криптографические абстракции ..");
////        System.out.println("Генерируем ключи рукопожатия ..");
////        System.out.println("*********************************");
////        System.out.println("Вас приветствует терминал криптоанализа");
////        System.out.println("Введите одну из доступных команд: \n"+
////                            "   1. Зашифровать текст \n" +
////                            "   2. Расшифровать текст с помощью ключа \n" +
////                            "   3. Расшифровать текст с помощью brute force \n" +
////                            "   4. Расшифровать при помощи синтаксического анализа");
////
//  }

    private final static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;
    private final SendMessageServiceImpl sendMessageServiceImpl;
    private final IOFileServiceImpl ioFileServiceImpl;

    public Dialogue(){
        this.sendMessageServiceImpl = new SendMessageServiceImpl();
        this.ioFileServiceImpl = new IOFileServiceImpl();
        this.commandContainer = new CommandContainer(sendMessageServiceImpl, ioFileServiceImpl);
    }

    public void executeCommands() {
        try(Scanner scanner = new Scanner(System.in)) {
            while (sendMessageServiceImpl.isWorking()) {
                System.out.print("Введите команду -> ");
                String message = scanner.nextLine();
                String commandArg = "";
                if (message.startsWith(COMMAND_PREFIX)) {
                    String[] splitMessage = message.split(" ");
                    String commandIdentifier = splitMessage[0].toLowerCase();
                    if (splitMessage.length >= 2) {
                        commandArg = splitMessage[1];
                    }
                    commandContainer.retrieveCommand(commandIdentifier).execute(commandArg);
                } else {
                    commandContainer.retrieveCommand(NO.getCommandName()).execute(commandArg);
                }
            }
        }
    }

    public void startService(){
        commandContainer.retrieveCommand(WELCOME.getCommandName()).execute("");
        executeCommands();
    }



}
