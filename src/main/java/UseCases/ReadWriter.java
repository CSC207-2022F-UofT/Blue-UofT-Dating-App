package UseCases;
import Entities.UserGraph;

import java.io.IOException;
public interface ReadWriter extends SaveableToFile, ReadableFromFile{

    //commented out the functions as they're inherited from SaveableTOFile + ReadableFromFile
    //now it adheres to SOLID deisng principles - Interface segregation Principle
    //can extend more interfaces if needed

//    void saveToFile(String filepath, Object o) throws IOException;
//
//    Object readFromFile(String filepath) throws IOException, ClassNotFoundException;
}