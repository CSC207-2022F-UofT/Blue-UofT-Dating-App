package UseCases;
import Entities.UserGraph;

import java.io.IOException;
public interface ReadWriter {
    void saveToFile(String filepath, Object o) throws IOException;

    UserGraph readFromFile(String filepath) throws IOException, ClassNotFoundException;
}