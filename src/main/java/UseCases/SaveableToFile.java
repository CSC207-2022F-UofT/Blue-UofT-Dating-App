package UseCases;

import java.io.IOException;

/**
 * SaveableToFile is an interface for saving data
 * to serialized files.
 *
 * @author Rudy
 * @since 1.0
 */
public interface SaveableToFile {

    void saveToFile(String filepath, Object o) throws IOException;

}
