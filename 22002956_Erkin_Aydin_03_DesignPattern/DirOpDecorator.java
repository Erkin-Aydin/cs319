import java.util.ArrayList;

public class DirOpDecorator extends SeparateLines implements DirOp{
    private DirOp dirOp;    //Next DirOp.

    /**
     * This is the constructor for DirOpDecorator class.
     * @param dirOp
     */
    DirOpDecorator(DirOp dirOp) {
        this.dirOp = dirOp;
    }

    /**
     * This method is used to print using its dirOp attribute.
     * @param toUpdate String representation of the contents of a directory that will be updated.
     */
    @Override
    public void display(String toUpdate) {
        dirOp.display(toUpdate);
    }
}
