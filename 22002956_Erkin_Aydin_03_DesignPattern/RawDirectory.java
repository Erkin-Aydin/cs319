/**
 * The purpose of this class may be unclear. It functions as a stop point for the decorator design pattern. It is the
 * concrete component of the Decorator design pattern I used. The reason I named this class "RawDirectory" is because
 * it is used to print whatever it gets without any change, raw.
 */
public class RawDirectory implements DirOp{
    /**
     * This method can be used to print the string directly, without any change.
     * @param toUpdate String representation of the contents of a directory that will be updated.
     */
    @Override
    public void display(String toUpdate) {
        System.out.println(toUpdate);
    }
}
