import java.util.ArrayList;

public class Directory extends FileSystemElement {

    private MemoryBehavior memoryBehavior;              //The memory behavior of Directory.
    private String directoryName;                //Name of the directory
    private ArrayList<FileSystemElement> list;  //The list of FileSystemElements in the directory.

    /**
     * This is a constructor for Directory class. It sets the attribute directoryName to the parameter directoryName,
     * and creates an empty list. It sets memoryBehavior to null.
     * @param directoryName
     */
    Directory(String directoryName) {
        this.directoryName = directoryName;
        list = new ArrayList<>();
        memoryBehavior = null;
    }

    /**
     * This is another constructor for Directory class.It sets the attribute directoryName to the parameter directoryName,
     * creates an empty list, and sets attribute memoryBehavior to the parameter memoryBehavior.
     * I didn't use this constructor, as it was not necessary. However, if wished, this can be used too.
     * @param directoryName
     * @param memoryBehavior
     */
    Directory(String directoryName, MemoryBehavior memoryBehavior) {
        this.directoryName = directoryName;
        list = new ArrayList<>();
        adjustMemoryRepresentation(memoryBehavior);
    }

    /**
     * @return the String representation of contents of the Directory object.
     */
    @Override
    public String getInfo() {
        String info = "- " + directoryName;
        for(int i = 0; i < list.size(); i++) {
            info = info + "\n" + list.get(i).getInfo();
        }
        info = info + "\n" + "- DIRECTORY END | " + directoryName;
        return info;

    }

    /**
     * This method is used to add FileSystemElements into the Directory object.
     * @param content FileSystemElements to be added.
     */
    public void addContent(FileSystemElement content) {
        list.add(content);
    }

    /**
     * This method is used to set a new MemoryBehavior to the Directory object.
     * @param memoryBehavior new MemoryBehavior of the Directory.
     */
    public void adjustMemoryRepresentation(MemoryBehavior memoryBehavior) {
        this.memoryBehavior = memoryBehavior;
    }

    /**
     * This method is used to print the contents of the Directory object using its current MemoryRepresentation.
     */
    public void applyMemoryRepresentation() {
        if(memoryBehavior != null) {
            String info = memoryBehavior.showMemory(getInfo());
            System.out.println(info);
        }
        else {
            System.out.println("No memory behavior set for this directory.");
        }
    }
}
