import java.util.ArrayList;

public class TypeBased extends Base {

    /**
     * This method returns a type based representation of the contents of a directory.
     * @param info contents of a directory.
     * @return a type based representation of the contents of a directory.
     */
    @Override
    public String showMemory(String info) {
        ArrayList<String> lines = getLines(info);
        String typeBasedRepresentation = "{ ";
        int depth = 0;
        for(int i = 0; i < lines.size(); i++) {
            int dir = lines.get(i).indexOf('-');
            int dirEnd = lines.get(i).indexOf("DIRECTORY END");
            if(dir > -1 && dirEnd < 0) {
                typeBasedRepresentation = typeBasedRepresentation + "[D" + depth + " ";
                depth++;
            }
            else if (dir > -1 && dirEnd > -1) {
                depth--;
                typeBasedRepresentation = typeBasedRepresentation + "EOD" + depth + "] ";
            }
            else {
                typeBasedRepresentation = typeBasedRepresentation + "(F) ";
            }
        }
        typeBasedRepresentation = typeBasedRepresentation + "}";
        return typeBasedRepresentation;
    }
}
