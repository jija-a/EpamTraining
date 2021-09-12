package controller.command.impl;

import controller.command.Command;
import domain.Matrix;
import service.MatrixService;
import service.ServiceException;
import service.impl.MatrixServiceImpl;
import view.ConsoleWriter;

public class MatrixPhaserFillCommand implements Command {

    private static MatrixService service;

    public MatrixPhaserFillCommand() {
        service = new MatrixServiceImpl();
    }

    @Override
    public void execute() throws ServiceException {

        Matrix matrix = service.readMatrix();
        service.fillMatrixWithPhaseThread();

        ConsoleWriter.write(matrix.toString());
    }


}
