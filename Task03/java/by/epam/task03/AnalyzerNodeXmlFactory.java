package by.epam.task03;

import by.epam.task03.command.AnalyzerNodeXmlDirector;
import by.epam.task03.command.Command;

public class AnalyzerNodeXmlFactory {

    public static final AnalyzerNodeXmlFactory instance = new AnalyzerNodeXmlFactory();

    private final AnalyzerNodeXmlDirector analyzerNodeXmlDirector = new AnalyzerNodeXmlDirector();

    private AnalyzerNodeXmlFactory() {}

    public static AnalyzerNodeXmlFactory getInstance() {
        return instance;
    }

    public Command getAnalyzerNodeXmlCreator(String nameOfAnalyzerNodeXml) {
        return analyzerNodeXmlDirector.getCreator(nameOfAnalyzerNodeXml);
    }

}
