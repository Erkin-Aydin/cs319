import java.util.ArrayList;

/**
 * This class can be used for the "indent" feature.
 */
public class Indenter extends DirOpDecorator{

    /**
     * This is a constructor for the Indenter class
     * @param dirOp
     */
    Indenter(DirOp dirOp) {
        super(dirOp);
    }

    /**
     * This method indents the lines of the parameter String and then calls the next decorator.
     * @param toUpdate String representation of the contents of a directory that will be updated.
     */
    @Override
    public void display(String toUpdate) {
        super.display(indent(getLines(toUpdate)));
    }

    /**
     * This method takes the lines of the contents of a directory in an ArrayList format, indents those lines, and then
     * concatenates them and returns the concatenated version.
     * The depth increases when we enter the directory. So, depth should be greater inside the directory than corresponding
     * directory lines. Hence, depth is incremented after the beginning line of a directory is indented.
     * A similar logic applies to the ending lines of directories. We need to decrement the depth before indenting the line.
     * @param lines contents of a directory in an ArrayList format
     * @return indented and concatenated version of the parameter ArrayList of Strings.
     */
    private String indent(ArrayList<String> lines) {
        int depth = 1;      //for indentation purposes. It denotes how much it will be indented.
        //Iterating over lines, one by one...
        for(int i = 1; i < lines.size(); i++) {
            //If the line is a directory line, this is greater than -1.
            int dirFound = lines.get(i).indexOf("-");
            //If the line is an end of directory line, this is greater than -1
            int dirEnd = lines.get(i).indexOf("- DIRECTORY END");
            //This is true if it is the end of a directory.
            if(dirFound > -1 && dirEnd > -1){
                depth--;
            }
            String toAdd = lines.get(i);        //we get the line to indent
            //we indent the line wrt. its depth
            for(int j = 0; j < depth; j++) {
                toAdd = "    " + toAdd;
            }
            lines.remove(i);            //removing the old line
            lines.add(i, toAdd);        //adding the updated version

            //This is true if it is the beginning of a directory.
            if(dirFound > -1 && dirEnd < 0){
                depth++;
            }
        }
        //Adding lines to a String and returning it.
        String toReturn = lines.get(0);
        for(int i = 1; i < lines.size(); i++) {
            toReturn = toReturn + "\n" + lines.get(i);
        }
        return toReturn;
    }
}
