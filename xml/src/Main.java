import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        final Path path = Paths.get(".").toAbsolutePath();

        final Document document = Tree.createXmlDocument(path);

        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        final DOMSource source = new DOMSource(document);
        // вот так можно выводить в стандартный вывод:
//        final StreamResult streamResult = new StreamResult(System.out);

        // вывод в файл
        final StreamResult streamResult = new StreamResult(new FileWriter("output.xml"));
        transformer.transform(source, streamResult);
    }
}