import data.Address;
import parser.XMLParser;

import java.io.File;
import java.util.List;

public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        List<? extends Object> addresses = xmlParser.parse(new File("address.xml"));
        List<? extends Object> clients = xmlParser.parse(new File("client.xml"));

        if (addresses != null){
            System.out.println(addresses);
        }

        if (clients != null){
            System.out.println(clients);
        }
    }
}
