package by.epam.task03;

import java.io.*;

public class XmlReader implements AutoCloseable {

    private final char openingSymbol = '<';

    private final char closingSymbol = '>';

    private BufferedReader bufferedReader;

    public XmlReader(Reader in, int sz) {
        bufferedReader = new BufferedReader(in, sz);
    }

    public XmlReader(Reader in) {
        bufferedReader = new BufferedReader(in);
    }

    public String readNode() throws IOException {
        StringBuilder s = new StringBuilder();
        final int endFile = -1;
        String emptySpaceRegex = " +";
        int readCharNumber;

        while ((readCharNumber = bufferedReader.read()) != endFile) {
            if ((readCharNumber == (int) openingSymbol) || (readCharNumber == (int) closingSymbol)) {
                if (s.toString().matches(emptySpaceRegex)) {
                    s.delete(0, s.length());
                }
                else if (!s.toString().isEmpty()) {
                    if (readCharNumber == (int) closingSymbol) {
                        s.append(closingSymbol);
                        return openingSymbol + s.toString();
                    }
                    return s.toString();
                }
            }
            else if (!((readCharNumber == (int) '\n') || (readCharNumber == (int) '\r'))) {
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
