package WS_evo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by berserk on 25.11.2017.
 */
public class EP {
        static final int PORT = 1488;
        public static void main(String[] args) throws IOException {
            ServerSocket s = new ServerSocket(PORT);

            InetAddress addr = InetAddress.getByName(null);
            System.out.println("Server Started");
            System.out.println(addr);
            System.out.println(s);
            try {
                while (true) {
                    // Блокируется до возникновения нового соединения:
                    Socket socket = s.accept();
                    try {
                        System.out.println(socket);
                        new ServeOne(socket);
                    }
                    catch (IOException e) {
                        // Если завершится неудачей, закрывается сокет,
                        // в противном случае, нить закроет его:
                        socket.close();
                    }
                }
            }
            finally {
                s.close();
            }
        }
    }






class ServeOne extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServeOne(Socket s) throws IOException {
        socket = s;
        /*
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        System.out.println("Ща буит XML");
        System.out.println(sb.toString());
        */






        /*BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
        sb.append(line);
        */
        // Включаем автоматическое выталкивание:
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                .getOutputStream())), true);
        start(); // вызываем run()
    }

    public void run() {
        try {
            while (true) {
                //socket = s;
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
/*
                String line = "";
                StringBuilder sb = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println("Ща буит XML");
                System.out.println(sb.toString());
                    //String str = in.readLine();
*/
                InputStream bais =
                        new ByteArrayInputStream(baos.toByteArray());

                //Object o = unmarshaller.unmarshal(bais);

                    JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
                    //Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    //Request request = (Request) jaxbUnmarshaller.unmarshal(in.readLine());
                Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
                    Request request = unmarshaller.unmarshal(?);
                    //if (str.equals("END"))
                    System.out.println("Echo: " + request);
                    //out.println(str);
                break;
                                                }
            System.out.println("closing...");
        }
        catch (JAXBException e) {
            System.out.println("доигрался");
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        catch (UnsupportedEncodingException e) {
            System.err.println("я твоя не понимать");
        }
        catch (IOException e) {
            System.err.println("Socket not closed");
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}

/*
class Base extends HashMap{


    public static Integer login;
    private static HashMap<Integer, LInfo> base = new HashMap<Integer, LInfo>();

    //String password;
        //static int balance;

        public static LInfo CREATE_AGT(HashMap<Integer, LInfo> base, int login, String password){
            LInfo linfo = new LInfo(password, 0);
           base.put(login, linfo);
           return linfo;
           //System.out.println(login, " ", linfo);
        }

        public static void GET_BALANCE(HashMap<Integer, LInfo> base, int login, String password) {

        /*
            Iterator<base.Entry<login, LInfo>> iterator = base.entrySet().iterator();

            while (iterator.hasNext())
            {
                //получение «пары» элементов
                base.Entry<login, LInfo> pair = iterator.next();
                String key = (login) pair;
                LInfo linfo = ((LInfo) pair);
                System.out.println(key, linfo);
                if (login == key) {
                    if (linfo.password == password) {
                        return linfo.balance;
                    }
                return 999; //дописать обратботку.Ошибка №4
                }
                return 888; //Ошибка #3
                //String value = pair.getValue();
                //System.out.println(key + ":" + value);
            }

        }
        }
        */

    //System.out.println(linfo);



/*
        Base<int, LInfo> base = new HashMap<int,LInfo>();
        System.out.println("hello");

        LInfo linfo = new LInfo("wtf!", 0);
        System.out.println(linfo);
        //test

        LInfo testinfo = new LInfo("wtf?", 5);
        int login = 1;

        //testinfo.balance = 5;
        //testinfo.password= "wtf?";
        base.put(login, testinfo);
        System.out.println(base.get(login));
        //
            //нужно ли запускать базу и инициализировать значения из файла конфигурации
            */




