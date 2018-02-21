package by.epam.task03;

public class XmlNodeTypeDefiner {

    public static XmlNodeType defineType(String stringNode) {
        String openingTagRegex = "^<[^!?/].+>$";//1 - в поля класса переменные - иначе зачем тебе ссылки на них при каждом вызове создавать
        String closingTagRegex = "^</.+>$";// 2 - а более логично не получилось реализовать, через HashMap и итерирование по нему?, а не через целую цепочку if-в
        String commentTagRegex = "^<!.+>$";
        String tagWithOutBodyRegex = "^<.+/>$";
        String headTagRegex = "^<[?].+[?]>$";

        if (stringNode.matches(tagWithOutBodyRegex)) {
            return XmlNodeType.TAG_WITHOUT_BODY;
        } else if (stringNode.matches(closingTagRegex)) {
            return XmlNodeType.CLOSING_TAG;
        } else if (stringNode.matches(commentTagRegex)) {
            return XmlNodeType.COMMENT;
        } else if (stringNode.matches(openingTagRegex)) {
            return XmlNodeType.OPENING_TAG;
        } else if (stringNode.matches(headTagRegex)) {
            return XmlNodeType.HEAD_TAG;
        } else {
            return XmlNodeType.CHARACTER;
        }
    }

}
