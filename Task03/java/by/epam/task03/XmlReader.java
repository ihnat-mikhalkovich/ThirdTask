package by.epam.task03;

import java.io.*;

public class XmlReader implements AutoCloseable {

    private final char OPENING_SYMBOL = '<';

    private final char CLOSING_SYMBOL = '>';

    private final char END_LINE = '\n';

    private final char CARRIAGE_RETURN = '\r';

    private final int END_FILE = -1;

    private BufferedReader bufferedReader;

    public XmlReader(Reader in, int sz) {// Reader in, int sz - ну нет на вас розог, Sz - чтоб это твоя кличка была...
        bufferedReader = new BufferedReader(in, sz);
    }

    public XmlReader(Reader in) {
        bufferedReader = new BufferedReader(in);
    }

    public String readNode() throws IOException {
        StringBuilder s = new StringBuilder();
        String emptySpaceRegex = " +";
        int readCharNumber;

        // логика реализации кривовата, не додумал хорошо
        while ((readCharNumber = bufferedReader.read()) != END_FILE) {// читаешь символ
            if ((readCharNumber == (int) OPENING_SYMBOL) || (readCharNumber == (int) CLOSING_SYMBOL)) {// Если прочитанный символ < или >
                if (s.toString().matches(emptySpaceRegex)) {// пустую строку ( при первом заходе) ты сравниваешь с пробелами??????
                    s.delete(0, s.length()); //так ты только объект создал - начего туде не добавил, зачем его сравнивать?
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
            if (!((readCharNumber == (int) END_LINE) || (readCharNumber == (int) CARRIAGE_RETURN))) {
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
