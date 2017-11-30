package WS_evo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Unmarsh {
        public static void main(String[] args) {

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                //Request request = (Request) jaxbUnmarshaller.unmarshal(file);
                //System.out.println(request);

            } catch (JAXBException e) {
                e.printStackTrace();
            }

        }
    }


@XmlRootElement
class Request {
    String ReqType;
    String extra;
    String extra_name;
    int result;

    public String getReqType()
    {
        return ReqType;
    }

    @XmlElement
    public void setReqType(String ReqType)
    {
        this.ReqType = ReqType;
    }

    public String getextra()
    {
        return extra;
    }

    @XmlElement
    public void setextra(String extra)
    {
        this.extra = extra;
    }

    public String getextra_name(String extra_name)
    {
        return extra_name;
    }

    @XmlAttribute
    public void setextra_name(String extra_name)
    {
        this.extra_name = extra_name;
    }

    @XmlElement
    public void setResultcode(int result)
    {
        this.result = result;
    }



}

