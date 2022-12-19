public class File extends FileSystemElement {

    private String fileName;     //Name of the file
    private String extension;    //Extension of the file(mp3, pdf...)
    private int fileSize;        //Size of the file in kb

    /**
     * This is the constructor of the File class. It sets attributes to corresponding parameters.
     * @param fileName
     * @param extension
     * @param fileSize
     */
    File(String fileName, String extension, int fileSize) {
        this.fileName = fileName;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    /**
     * This method returns the String representation of the file object.
     * @return the String representation of the File object.
     */
    @Override
    public String getInfo() {
        return fileName + "." + extension + " | File Size: " + fileSize + " kb";
    }
}