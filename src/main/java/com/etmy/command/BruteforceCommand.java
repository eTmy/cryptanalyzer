package com.etmy.command;

import com.etmy.cryptology.Cryptology;
import com.etmy.io.IO;
import com.etmy.service.IOFileService;
import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BruteforceCommand implements Command{

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public static final String SUCCESS_ENCODE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Файл успешно декодирован. Теперь вы можете узнать чужую тайну (ง︡'-'︠)ง ";
    public static final String TRY_DECODE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Выше предоставлен один из вариантов сообщения:";

    public BruteforceCommand (SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        String srcReadFile = ioFileService.getReadPath();
        String srcWriteFile = ioFileService.getWritePath();
        List<String> bruteforceResultList = new ArrayList<>();
        try {
            List<String> fileLines = IO.readFileAndReturnListOfStrings(srcReadFile);
            for (int i = 0; i < 43; i++) {
                List<String> decodedFileLines = Cryptology.decode(fileLines, i * -1);
                bruteforceResultList.addAll(decodedFileLines);
                bruteforceResultList.add(SendMessageServiceImpl.DELIMITER_MESSAGE);
            }
            IO.writeFile(srcWriteFile, bruteforceResultList);
            sendMessageService.sendMessage(SUCCESS_ENCODE_MESSAGE);
        } catch (IOException exception) {
            sendMessageService.sendMessage(exception.getMessage());
        }

    }
}
