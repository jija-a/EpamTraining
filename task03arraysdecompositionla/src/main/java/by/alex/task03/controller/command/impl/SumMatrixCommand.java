package by.alex.task03.controller.command.impl;

import by.alex.task03.controller.command.Command;
import by.alex.task03.domain.Matrix;
import by.alex.task03.service.MatrixService;
import by.alex.task03.service.ServiceFactory;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.InputReader;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class SumMatrixCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumMatrixCommand.class);
    private final MatrixService matrixService;
    private final MessageManager messageManager;

    public SumMatrixCommand() {
        this.matrixService = ServiceFactory.getInstance().getMatrixService();
        this.messageManager = MessageManager.INSTANCE;
    }

    @Override
    public void execute() {
        LOGGER.trace("Executing sum matrices command");

        ConsoleWriter.writeln(matrixService.findAllMatrix().toString());
        ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.INPUT_FIRST_MATRIX_ID));
        Long firstMatrixId = InputReader.readLong();
        ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.INPUT_SECOND_MATRIX_ID));
        Long secondMatrixId = InputReader.readLong();

        Optional<Matrix> firstMatrix = matrixService.findMatrixById(firstMatrixId);
        Optional<Matrix> secondMatrix = matrixService.findMatrixById(secondMatrixId);

        if (firstMatrix.isEmpty() || secondMatrix.isEmpty()) {
            ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.OUTPUT_ERROR_MATRIX_NOT_FOUND));
        } else {
            try {
                Matrix resultMatrix = matrixService.sum(firstMatrix.get(), secondMatrix.get());
                ConsoleWriter.writeln(resultMatrix.toString());
            } catch (IllegalArgumentException e) {
                LOGGER.trace("Wrong arguments for sum");
                ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.OUTPUT_ERROR_WRONG_ARGUMENTS));
            }
        }
    }

}
