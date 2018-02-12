package by.epam.task03.command;

import by.epam.task03.AnalyzerNodeXml;
import by.epam.task03.impl.AnalyzerNodeXmlImpl;

import java.io.Reader;

public class AnalyzerNodeXmlImplCreator implements Command {

    @Override
    public AnalyzerNodeXml execute(Reader in) {
        return new AnalyzerNodeXmlImpl(in);
    }

}
