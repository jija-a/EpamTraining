package by.alex.task08.service.builder.xml;

import by.alex.task08.service.builder.xml.dom.PaperDOMBuilder;
import by.alex.task08.service.builder.xml.sax.PaperSAXBuilder;
import by.alex.task08.service.builder.xml.stax.PaperStAXBuilder;

public class PaperXMLBuilderFactory {
    private enum TypeParser {
        DOM, STAX, SAX;
    }

    private PaperXMLBuilderFactory() {
    }

    public static AbstractPaperBuilder createPaperBuilder(
            final String typeParser) {

        AbstractPaperBuilder builder;
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                builder = new PaperDOMBuilder();
                break;
            case SAX:
                builder = new PaperSAXBuilder();
                break;
            case STAX:
                builder = new PaperStAXBuilder();
                break;
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
        return builder;
    }
}
