package by.epam.test_task03;

import by.epam.task03.AnalyzerNodeXml;
import by.epam.task03.AnalyzerNodeXmlFactory;
import by.epam.task03.XmlNode;
import by.epam.task03.command.Command;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String sourcePath = "example.txt";
        AnalyzerNodeXmlFactory analyzerNodeXmlFactory = AnalyzerNodeXmlFactory.getInstance();
        Command command = analyzerNodeXmlFactory.getAnalyzerNodeXmlCreator("AnalyzerNodeXmlImpl");
        AnalyzerNodeXml analyzerNodeXml = null;
        try (FileReader fileReader = new FileReader(sourcePath)) {
            analyzerNodeXml = command.execute(fileReader);
            XmlNode xmlNode;
            while ((xmlNode = analyzerNodeXml.next()) != null) {
                System.out.println(xmlNode.getContent() + " - " + xmlNode.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                analyzerNodeXml.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
