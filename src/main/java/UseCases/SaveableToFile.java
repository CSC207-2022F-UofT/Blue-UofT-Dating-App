package UseCases;

import java.io.IOException;

public interface SaveableToFile {

    void saveToFile(String filepath, Object o) throws IOException;

}
