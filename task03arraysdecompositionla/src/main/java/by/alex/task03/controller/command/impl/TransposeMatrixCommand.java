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

public class TransposeMatrixCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransposeMatrixCommand.class);
    private final MatrixService matrixService;
    private final MessageManager messageManager;

    public TransposeMatrixCommand() {
        this.matrixService = ServiceFactory.getInstance().getMatrixService();
        this.messageManager = MessageManager.INSTANCE;
    }

    @Override
    public void execute() {
        LOGGER.trace("Executing transpose matrix command");

        ConsoleWriter.writeln(matrixService.findAllMatrix().toString());
        ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.INPUT_MATRIX_ID));
        Long matrixId = InputReader.readLong();

        Optional<Matrix> matrix = matrixService.findMatrixById(matrixId);

        if (matrix.isEmpty()) {
            ConsoleWriter.writeln(messageManager.getMessage(MessageConstant.OUTPUT_ERROR_MATRIX_NOT_FOUND));
        } else {
            Matrix resultMatrix = matrixService.transpose(matrix.get());
            ConsoleWriter.writeln(resultMatrix.toString());
        }
    }

}
