package by.epam.task03.command;

import by.epam.task03.AnalyzerNodeXml;

import java.io.Reader;

public interface Command {

    AnalyzerNodeXml execute(Reader in);

}
