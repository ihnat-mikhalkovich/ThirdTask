package by.epam.task03;

public class XmlNode implements Comparable<XmlNode>{// Comparable<XmlNode> - как-то не рпеполагала, что для такого объекта есть естественная сортировка

    private String content;

    private XmlNodeType type;

    public XmlNode(String stringNode) {
        content = stringNode;
        type = XmlNodeTypeDefiner.defineType(stringNode);
    }

    public XmlNode (String content, XmlNodeType type) {
        this.content = content;
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(XmlNodeType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public XmlNodeType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XmlNode xmlNode = (XmlNode) o;

        if (content != null ? !content.equals(xmlNode.content) : xmlNode.content != null) return false;
        return type == xmlNode.type;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(XmlNode o) {
        return this.type.compareTo(o.getType());
    }
}
