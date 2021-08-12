package by.alex.task03.domain;

import by.alex.task03.util.PropertyReaderUtil;

import java.util.Objects;

public class ApplicationProperties {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();

    private final String inputDir = PropertyReaderUtil.loadProperty("inputDir");
    private final String arrayFileName = PropertyReaderUtil.loadProperty("arrayFileName");
    private final String matrixFileName = PropertyReaderUtil.loadProperty("matrixFileName");

    public String getInputDir() {
        return inputDir;
    }

    public String getArrayFileName() {
        return arrayFileName;
    }

    public String getMatrixFileName() {
        return matrixFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationProperties that = (ApplicationProperties) o;
        return Objects.equals(inputDir, that.inputDir) && Objects.equals(arrayFileName, that.arrayFileName) && Objects.equals(matrixFileName, that.matrixFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputDir, arrayFileName, matrixFileName);
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "inputDir='" + inputDir + '\'' +
                ", arrayFileName='" + arrayFileName + '\'' +
                ", matrixFileName='" + matrixFileName + '\'' +
                '}';
    }

}
