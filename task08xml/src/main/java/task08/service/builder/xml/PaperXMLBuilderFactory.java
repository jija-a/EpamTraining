package task08.service.builder.xml;

import task08.service.builder.xml.dom.PaperDOMBuilder;
import task08.service.builder.xml.sax.PaperSAXBuilder;
import task08.service.builder.xml.stax.PaperStAXBuilder;

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
