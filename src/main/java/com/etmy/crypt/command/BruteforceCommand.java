package com.etmy.crypt.command;

import com.etmy.crypt.cryptology.Cryptology;
import com.etmy.crypt.io.IO;
import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.SendMessageServiceImpl;
import com.etmy.crypt.service.IOFileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BruteforceCommand implements Command {

    private static final String SUCCESS_ENCODE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            + "Файл успешно декодирован. Теперь вы можете узнать чужую тайну (ง︡'-'︠)ง ";

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public BruteforceCommand(SendMessageService sendMessageService, IOFileService ioFileService) {
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        String inputFile = ioFileService.getReadPath();
        String outputFile = ioFileService.getWritePath();
        List<String> bruteforceResultList = new ArrayList<>();
        try {
            List<String> fileLines = IO.readFileAndReturnListOfStrings(inputFile);
            for (int i = 0; i < Cryptology.ALPHABET.length ; i++) {
                List<String> decodedFileLines = Cryptology.decode(fileLines, i * -1);
                bruteforceResultList.addAll(decodedFileLines);
                bruteforceResultList.add(SendMessageServiceImpl.DELIMITER_MESSAGE);
            }
            IO.writeFile(outputFile, bruteforceResultList);
            sendMessageService.sendMessage(SUCCESS_ENCODE_MESSAGE);
        } catch (IOException exception) {
            sendMessageService.sendMessage(exception.getMessage());
        }

    }
}
