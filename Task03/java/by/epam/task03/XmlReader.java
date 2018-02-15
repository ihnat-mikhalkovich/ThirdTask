package by.epam.task03;

import java.io.*;

public class XmlReader implements AutoCloseable {

    private final char OPENING_SYMBOL = '<';

    private final char CLOSING_SYMBOL = '>';

    private final int END_FILE = -1;

    private BufferedReader bufferedReader;

    public XmlReader(Reader in, int sz) {
        bufferedReader = new BufferedReader(in, sz);
    }

    public XmlReader(Reader in) {
        bufferedReader = new BufferedReader(in);
    }

    public String readNode() throws IOException {
        StringBuilder s = new StringBuilder();
        String emptySpaceRegex = " +";
        int readCharNumber;

        while ((readCharNumber = bufferedReader.read()) != END_FILE) {
            if ((readCharNumber == (int) OPENING_SYMBOL) || (readCharNumber == (int) CLOSING_SYMBOL)) {
                if (s.toString().matches(emptySpaceRegex)) {
                    s.delete(0, s.length());
                    continue;
                }
                if (s.toString().isEmpty()) {
                    continue;
                }
                if (readCharNumber == (int) CLOSING_SYMBOL) {
                    s.append(CLOSING_SYMBOL);
                    return OPENING_SYMBOL + s.toString().trim();
                }
                return s.toString();
            }
            if (!((readCharNumber == (int) '\n') || (readCharNumber == (int) '\r'))) {
                s.append((char) readCharNumber);
            }
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }

}
