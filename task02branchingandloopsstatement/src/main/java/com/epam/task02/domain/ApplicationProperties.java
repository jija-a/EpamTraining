package com.epam.task02.domain;

import com.epam.task02.context.util.InputType;
import com.epam.task02.util.PropertyReaderUtil;

public class ApplicationProperties {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();

    private final String inputRootDir = PropertyReaderUtil.loadProperties("inputRootDir");
    private final String numbersFileName = PropertyReaderUtil.loadProperties("numbersFileName");
    private InputType inputType = InputType.CONSOLE;

    public String getInputRootDir() {
        return inputRootDir;
    }

    public String getNumbersFileName() {
        return numbersFileName;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

}
