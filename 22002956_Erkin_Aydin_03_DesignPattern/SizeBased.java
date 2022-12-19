import java.util.ArrayList;

public class SizeBased extends Base {

    /**
     * This method returns a size based representation of the contents of a directory.
     * @param info contents of a directory.
     * @return a size based representation of the contents of a directory.
     */
    @Override
    public String showMemory(String info) {
        ArrayList<String> lines = getLines(info);
        String sizeBasedRepresentation = "{ ";
        for(int i = 0; i < lines.size(); i++) {
            int dir = lines.get(i).indexOf('-');
            int dirEnd = lines.get(i).indexOf("DIRECTORY END");
            if(dir > -1 && dirEnd < 0) {
                sizeBasedRepresentation = sizeBasedRepresentation + "[ ";
            }
            else if(dir > -1 && dirEnd > -1) {
                sizeBasedRepresentation = sizeBasedRepresentation + "] ";
            }
            else {
                int kbEnd = lines.get(i).indexOf("kb") - 1;
                int kbBegin = lines.get(i).indexOf("File Size: ") + 11;
                String kb =lines.get(i).substring(kbBegin, kbEnd);
                sizeBasedRepresentation = sizeBasedRepresentation + "(" + kb + ") ";
            }
        }
        sizeBasedRepresentation = sizeBasedRepresentation + "}";
        return sizeBasedRepresentation;
    }
}
