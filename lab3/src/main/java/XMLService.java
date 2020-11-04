import hotel.Occupancy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLService {

    // сохраняет объект Occupancy в XML документ
    public static void saveOccupancyData(Occupancy occupancy) {
        try {
            //создание объекта Marshaller, который выполняет сериализацию
            JAXBContext context = JAXBContext.newInstance(Occupancy.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // маршаллинг объекта в файл
            marshaller.marshal(occupancy, new File("occupancy.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // преобразует XML документ в объект типа Occupancy
    public static Occupancy loadOccupancyFromXML() {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Occupancy.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Occupancy) un.unmarshal(new File("C:\\Users\\Asus\\IdeaProjects\\lab3\\occupancy.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}