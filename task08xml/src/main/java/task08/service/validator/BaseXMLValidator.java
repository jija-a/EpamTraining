package task08.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import task08.service.builder.xml.sax.PaperErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public final class BaseXMLValidator {

    /**
     * Class Logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(BaseXMLValidator.class);

    /**
     * Private constructor, because methods are static.
     */
    private BaseXMLValidator() {
    }

    /**
     * Method to validate xml and xsd files.
     *
     * @param xmlFileName - path to xml file
     * @param xsdFileName - path to xsd file
     * @return {@link Boolean} true if valid, false - if not
     */
    public static boolean isCorrectXml(final String xmlFileName,
                                       final String xsdFileName) {

        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(xsdFileName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFileName);
            validator.setErrorHandler(new PaperErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            LOGGER.error("{} is not correct or valid", xmlFileName, e);
            return false;
        }
        return true;
    }
}
