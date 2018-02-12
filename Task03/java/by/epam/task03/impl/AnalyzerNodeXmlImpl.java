package by.epam.task03.impl;

import by.epam.task03.AnalyzerNodeXml;
import by.epam.task03.XmlNode;
import by.epam.task03.XmlReader;
import java.io.*;

public class AnalyzerNodeXmlImpl implements AnalyzerNodeXml, AutoCloseable {

    XmlReader xmlReader;

    public AnalyzerNodeXmlImpl(Reader in, int sz) {
        xmlReader = new XmlReader(in, sz);
    }

    public AnalyzerNodeXmlImpl(Reader in) {
        xmlReader = new XmlReader(in);
    }

    @Override
    public XmlNode next() throws IOException {
        String node = xmlReader.readNode();
        if (node == null) {
            return null;
        }
        return defineNode(node);
    }

    private XmlNode defineNode(String stringNode) {
        return new XmlNode(stringNode);
    }

    @Override
    public void close() throws IOException {
        xmlReader.close();
    }

}
