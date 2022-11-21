package parser;

import data.Address;
import data.Client;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements Parser {
    @Override
    public List<? extends Object> parse(File file) {
        return readData(file);
    }

    public List<? extends Object> readData(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        List<? extends Object> result = switch (file.getName()) {
            case "address.xml" -> readAddress(parser);
            case "client.xml" -> readClients(parser);
            default -> new ArrayList<>();
        };

        return result;
    }

    public List<? extends Object> readAddress(XMLStreamReader parser) {
        try {
            List<Address> addresses = new ArrayList<>();
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        long id = Long.parseLong(parser.getAttributeValue("", "id"));
                        String city = parser.getAttributeValue("", "city");
                        String street = parser.getAttributeValue("", "street");
                        int house = Integer.parseInt(parser.getAttributeValue("", "house"));
                        int floor = Integer.parseInt(parser.getAttributeValue("", "floor"));
                        int flatNumber = Integer.parseInt(parser.getAttributeValue("", "flatNumber"));
                        addresses.add(new Address(id, city, street, house, floor, flatNumber));
                    }
                }
            }
            return addresses;
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<? extends Object> readClients(XMLStreamReader parser) {
        try {
            List<Client> clients = new ArrayList<>();
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("client")) {
                        long id = Long.parseLong(parser.getAttributeValue("", "id"));
                        String name = parser.getAttributeValue("", "name");
                        String personnelNumber = parser.getAttributeValue("", "personnelNumber");
                        long addressId = Long.parseLong(parser.getAttributeValue("", "addressId"));
                        clients.add(new Client(id, name, personnelNumber, addressId));
                    }

                }
            }
            return clients;
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
