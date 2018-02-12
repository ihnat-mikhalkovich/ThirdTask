package by.epam.task03;

import java.io.IOException;

public interface AnalyzerNodeXml extends AutoCloseable {

    XmlNode next() throws IOException;

    @Override
    void close() throws IOException;
}
