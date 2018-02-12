package by.epam.task03;

public class XmlNodeTypeDefiner {

    public static XmlNodeType defineType(String stringNode) {
        String openingTagRegex = "^<[^!?/].+>$";
        String closingTagRegex = "^</.+>$";
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
