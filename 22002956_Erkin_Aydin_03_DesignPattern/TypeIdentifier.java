import java.util.ArrayList;

/**
 * This class is used for "Type Indication" feature.
 */
public class TypeIdentifier extends DirOpDecorator{

    /**
     * Constructor for TypeIdentifier class.
     * @param dirOp
     */public
    TypeIdentifier(DirOp dirOp) {
        super(dirOp);
    }

    /**
     * This method identifies the types of the lines of the parameter String and then calls the next decorator.
     * @param toUpdate String representation of the contents of a directory that will be updated.
     */
    @Override
    public void display(String toUpdate) {
        super.display(identify(getLines(toUpdate)));
    }

    /**
     * This method takes the contents of a directory in an ArrayList format, type identifies those lines, concatenates
     * them and returns them in the concatenated form.
     * @param lines contents of a directory in an ArrayList format
     * @return type identified and concatenated version of the parameter ArrayList of Strings.
     */
    private String identify(ArrayList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int dirIndex = line.indexOf('-');
            String toAdd = "";
            //If the line is a directory line, this is greater than -1.
            if(dirIndex > -1) {
                //If the line is an end of directory line, this is greater than -1
                if(line.indexOf("DIRECTORY END") > -1) {toAdd = "(!) ";}
                else {toAdd = "(d) ";}
            }
            else {toAdd = "(f) ";}
            toAdd = toAdd + line;
            lines.remove(i);
            lines.add(i, toAdd);
        }

        //Adding lines to a String and returning it.
        String toReturn = lines.get(0);
        for(int i = 1; i < lines.size(); i++) {
            toReturn = toReturn + "\n" + lines.get(i);
        }
        return toReturn;
    }
}
