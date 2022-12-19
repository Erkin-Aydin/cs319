public class Main {
    public static void main(String[] args) {

        System.out.println("Part 1:");
        Directory bilkentStuff = new Directory("BilkentStuff");

        bilkentStuff.addContent(new File("InternshipReport", "pdf", 10));
        bilkentStuff.addContent(new File("setup", "exe", 5));
        bilkentStuff.addContent(new File("ToDoList", "docx", 15));

        Directory dirToAdd = new Directory("FavoriteMusic");
        dirToAdd.addContent(new File("MetallicaTheUnforgiven","mp3",100));
        bilkentStuff.addContent(dirToAdd);

        Directory myDocuments = new Directory("MyDocuments");
        Directory myPc = new Directory("MyPC");
        myPc.addContent(myDocuments);
        myPc.addContent(bilkentStuff);
        System.out.println("MyPc Example:\n######################\n" + myPc.getInfo() + "\n######################");
        System.out.println("/////////////////////////////////////////");

        System.out.println("Part 2:");

        DirOp rawOp = new RawDirectory();
        DirOp typeAndIndent = new Indenter(new TypeIdentifier(rawOp));
        DirOp type = new TypeIdentifier(rawOp);
        DirOp indent = new Indenter(rawOp);
        System.out.println("MyPc Example with Type Identification:\n######################\n");
        type.display(myPc.getInfo());
        System.out.println("\n######################\n");

        System.out.println("MyPc Example with Indentation:\n######################\n");
        indent.display(myPc.getInfo());
        System.out.println("\n######################\n");

        System.out.println("MyPc Example with Type Identification and Indentation:\n######################\n");
        typeAndIndent.display(myPc.getInfo());
        System.out.println("\n######################\n");

        System.out.println("/////////////////////////////////////////");

        System.out.println("Part 3:");

        System.out.println("MyPc Example with Size Based Memory Representation:\n######################\n");
        myPc.adjustMemoryRepresentation(new SizeBased());
        myPc.applyMemoryRepresentation();
        System.out.println("\n######################\n");

        System.out.println("MyPc Example with Type Based Memory Representation:\n######################\n");
        myPc.adjustMemoryRepresentation(new TypeBased());
        myPc.applyMemoryRepresentation();
        System.out.println("\n######################\n");

    }
}