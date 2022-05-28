import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tree {

    private static Node processFile(final Document document, final Path path) {
        final Element xmlElement = document.createElement("file");

        xmlElement.setAttribute("name", path.getFileName().toString());
        xmlElement.setAttribute("path", path.toAbsolutePath().toString());

        return xmlElement;
    }

    public static Node processFolder(final Document document, final Path path) throws IOException {
        final Element xmlElement = document.createElement("directory");

        xmlElement.setAttribute("name", path.getFileName().toString());
        xmlElement.setAttribute("path", path.toAbsolutePath().toString());

        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (final Path pathElement : directoryStream) {
                if (Files.isDirectory(pathElement)) {
                    xmlElement.appendChild(processFolder(document, pathElement));
                } else {
                    xmlElement.appendChild(processFile(document, pathElement));
                }
            }
        }

        return xmlElement;
    }

    public static Document createXmlDocument(final Path path) throws ParserConfigurationException, IOException {
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        document.appendChild(processFolder(document, path));

        return document;
    }


}