package com.etmy.crypt.command;

import com.etmy.crypt.cryptology.Cryptology;
import com.etmy.crypt.service.SendMessageService;
import com.etmy.crypt.service.SendMessageServiceImpl;
import com.etmy.crypt.io.IO;
import com.etmy.crypt.service.IOFileService;

import java.io.IOException;
import java.util.List;

public class EncodeCommand implements Command{

    private final SendMessageService sendMessageService;
    private final IOFileService ioFileService;

    public static final String COUNT_CHARACTER_ERROR_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Количество сдвигаемых символов не может превышать 42 ";

    public static final String SUCCESS_ENCODE_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Файл успешно закодирован. Ваша тайна будет сохранена ( ˘︹˘ ) ";

    public static final String ERROR_ARG_MESSAGE = SendMessageServiceImpl.DELIMITER_MESSAGE + "\n"
            +"Вы забыли указать ключ шифрования (¬‿¬) ";

    public EncodeCommand (SendMessageService sendMessageService, IOFileService ioFileService){
        this.sendMessageService = sendMessageService;
        this.ioFileService = ioFileService;
    }

    @Override
    public void execute(String commandArg) {
        if ("".equals(commandArg)) {
            sendMessageService.sendMessage(ERROR_ARG_MESSAGE);
            return;
        }

        String srcReadFile = ioFileService.getReadPath();
        String srcWriteFile = ioFileService.getWritePath();
        int countCharacters = Integer.parseInt(commandArg);

        if (countCharacters < Cryptology.ALPHABET.length) {
            try {
                List<String> lines = IO.readFileAndReturnListOfStrings(srcReadFile);
                List<String> encodedFileLines = Cryptology.encode(lines, countCharacters);
                IO.writeFile(srcWriteFile, encodedFileLines);
                sendMessageService.sendMessage(SUCCESS_ENCODE_MESSAGE);
            } catch (IOException exception) {
                sendMessageService.sendMessage(exception.getMessage());
            }
        } else {
            sendMessageService.sendMessage(COUNT_CHARACTER_ERROR_MESSAGE);
        }
    }
}
