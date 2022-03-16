package com.etmy.command;

import com.etmy.cryptology.Cryptology;
import com.etmy.io.IO;
import com.etmy.service.IOFileService;
import com.etmy.service.SendMessageService;
import com.etmy.service.SendMessageServiceImpl;

import java.io.IOException;
import java.util.List;

public class DecodeCommand implements Command{

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public static final String COUNT_CHARACTER_ERROR_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Количество сдвигаемых символов не может превышать 42 ";

    public static final String SUCCESS_ENCODE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Файл успешно декодирован. Теперь вы можете узнать чужую тайну (ง︡'-'︠)ง ";

    public DecodeCommand (SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        String srcReadFile = ioFileService.getReadPath();
        String srcWriteFile = ioFileService.getWritePath();
        int countCharacters = Integer.parseInt(commandArg);

        if (countCharacters < 43) {
            try {
                List<String> fileLines = IO.readFileAndReturnListOfStrings(srcReadFile);
                List<String> decodedFileLines = Cryptology.decode(fileLines, countCharacters);
                IO.writeFile(srcWriteFile, decodedFileLines);
                sendMessageService.sendMessage(SUCCESS_ENCODE_MESSAGE);
            } catch (IOException exception) {
                sendMessageService.sendMessage(exception.getMessage());
            }
        } else {
            sendMessageService.sendMessage(COUNT_CHARACTER_ERROR_MESSAGE);
        }
    }
}
