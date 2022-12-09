package UseCases.dataretrieval;

import Entities.UserGraph;
import UseCases.ReadableFromFile;
import UseCases.SaveableToFile;

import java.io.*;

public class UserGraphReadWriter implements SaveableToFile, ReadableFromFile {

    @Override
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Graph
        output.writeObject(users);
        output.close();
    }

    @Override
    public UserGraph readFromFile(String filePath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        UserGraph userGraph = (UserGraph) input.readObject();
        input.close();
        return userGraph;
    }
}