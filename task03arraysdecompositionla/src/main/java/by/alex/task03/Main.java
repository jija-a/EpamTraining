package by.alex.task03;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.context.impl.ReadArrayFile;
import by.alex.task03.context.impl.ReadMatrixFile;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.MatrixException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws MatrixException, IOException {
         ReadMatrixFile readMatrixFile = new ReadMatrixFile();
        readMatrixFile.read("C:\\Users\\Lenovo\\IdeaProjects\\EpamTasks\\task03arraysdecompositionla\\src\\main\\resources\\input\\matrix.txt");
        System.out.println(ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class));
        ReadArrayFile readArrayFile = new ReadArrayFile();
        readArrayFile.read("C:\\Users\\Lenovo\\IdeaProjects\\EpamTasks\\task03arraysdecompositionla\\src\\main\\resources\\input\\array.txt");
        //Application.start();
    }

}
