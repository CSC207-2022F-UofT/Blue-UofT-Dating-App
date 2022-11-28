package UseCases;

import java.io.IOException;

public interface ReadableFromFile {

    Object readFromFile(String filepath) throws IOException, ClassNotFoundException;

}
