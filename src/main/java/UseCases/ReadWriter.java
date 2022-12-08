package UseCases;

/**
 * ReadWriter is an interface for reading from and writing to
 * serialized files. The ReadWriter interface extends two other
 * interfaces, SaveableToFile and ReadableFromFile. This design
 * choice allows programmers to extend the functionality of
 * ReadWriter as needed.
 *
 * @author Rudy
 * @author Ewan Jordan
 * @since 1.0
 */
public interface ReadWriter extends SaveableToFile, ReadableFromFile{

    //commented out the functions as they're inherited from SaveableTOFile + ReadableFromFile
    //now it adheres to SOLID deisng principles - Interface segregation Principle
    //can extend more interfaces if needed

}