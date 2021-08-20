package by.alex.task03.controller.command.impl;

import by.alex.task03.controller.command.Command;
import by.alex.task03.domain.CustomArray;
import by.alex.task03.service.CustomArrayService;
import by.alex.task03.service.ServiceFactory;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.InputReader;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class SelectionSortCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectionSortCommand.class);
    private final CustomArrayService arrayService;
    private final MessageManager messageManager;

    public SelectionSortCommand() {
        this.arrayService = ServiceFactory.getInstance().getArrayService();
        this.messageManager = MessageManager.INSTANCE;
    }

    @Override
    public void execute() {
        LOGGER.trace("Executing selection sort command");

        ConsoleWriter.writeln(arrayService.findAllArrays().toString());
        ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.INPUT_ARRAY_ID));
        Long arrayId = InputReader.readLong();

        Optional<CustomArray> array = arrayService.findArrayById(arrayId);

        if (array.isEmpty()) {
            ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.OUTPUT_ERROR_ARRAY_NOT_FOUND));
        } else {
            arrayService.selectionSort(array.get());
            ConsoleWriter.writeln(array.get().toString());
        }
    }
}
