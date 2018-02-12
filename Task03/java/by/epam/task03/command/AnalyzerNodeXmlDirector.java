package by.epam.task03.command;

import java.util.HashMap;
import java.util.Map;

public class AnalyzerNodeXmlDirector {

    private Map<String, Command> analyzerNodeXmlMap = new HashMap<>();

    public AnalyzerNodeXmlDirector() {
        analyzerNodeXmlMap.put("AnalyzerNodeXmlImpl", new AnalyzerNodeXmlImplCreator());
    }

    public Command getCreator(String nameOfAnalyzerNodeXml) {
        return analyzerNodeXmlMap.get(nameOfAnalyzerNodeXml);
    }
}
