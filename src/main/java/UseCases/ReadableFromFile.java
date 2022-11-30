package UseCases;

import java.io.IOException;

/**
 * ReadableFromFile is an interface for reading data
 * from serialized files.
 *
 * @author Rudy
 * @since 1.0
 */
public interface ReadableFromFile {

    Object readFromFile(String filepath) throws IOException, ClassNotFoundException;

}
