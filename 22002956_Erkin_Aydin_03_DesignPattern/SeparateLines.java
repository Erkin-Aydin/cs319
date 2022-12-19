import java.util.ArrayList;

public abstract class SeparateLines {

    /**
     * This method is crucial. This method is used to separate the lines in a string. Using this method, doing formatting
     * in the contents of directories is easier.
     * @param text
     * @return
     */
    public ArrayList<String> getLines(String text) {
        ArrayList<String> lines = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            int endLine = text.indexOf('\n', i);
            if(endLine < 0) {endLine = text.length();}
            lines.add(text.substring(i, endLine));
            i = endLine;
        }
        return lines;
    }
}
