package WS_evo;

import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import jdk.internal.org.xml.sax.Attributes;
/**
 * Created by berserk on 26.11.2017.
 */
public class Handler extends DefaultHandler {


    @Override
    public void startDocument() throws SAXException{
        System.out.println("Parser started...");

    }

    @Override
    public void endDocument() throws SAXException{
        System.out.println("End parsing...");

    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {

    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException{

    }


    @Override
    public void characters(char []ch, int start, int end) {
        String str = new String(ch, start, end);
        System.out.println(str);
        /*String str = "";
        for(int i = start; i < end;i++)
            str+= ch[i];
          */
    }
}
