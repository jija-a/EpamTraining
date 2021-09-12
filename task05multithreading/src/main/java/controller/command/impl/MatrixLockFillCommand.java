package controller.command.impl;

import controller.command.Command;
import domain.Matrix;
import service.MatrixService;
import service.ServiceException;
import service.impl.MatrixServiceImpl;
import view.ConsoleWriter;

public class MatrixLockFillCommand implements Command {

    private static MatrixService service;

    public MatrixLockFillCommand() {
        service = new MatrixServiceImpl();
    }

    @Override
    public void execute() throws ServiceException {

        Matrix matrix = service.readMatrix();
        service.fillMatrixWithLockThread();

        ConsoleWriter.write(matrix.toString());
    }

}
