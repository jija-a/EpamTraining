package by.alex.task08.service.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BaseXMLValidatorTest {
    private static final String PATH_TO_CORRECT_XML = "src/test/resources/papersTest.xml";
    private static final String PATH_TO_CORRECT_XSD = "src/test/resources/papersTest.xsd";

    private static final String PATH_TO_INCORRECT_XML = "src/test/resources/notValidPapersTest.xml";
    private static final String PATH_TO_INCORRECT_XSD = "src/test/resources/notValidPapersTest.xsd";

    @Test
    public void isCorrectXmlTest() {
        boolean value = BaseXMLValidator.isCorrectXml(PATH_TO_CORRECT_XML, PATH_TO_CORRECT_XSD);
        assertTrue(value);
    }

    @Test
    public void isIncorrectXmlTest() {
        boolean value = BaseXMLValidator.isCorrectXml(PATH_TO_INCORRECT_XML, PATH_TO_INCORRECT_XSD);
        assertFalse(value);
    }
}
