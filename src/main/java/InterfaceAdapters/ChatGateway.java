package InterfaceAdapters;

import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.ReadWriter;

import java.io.*;

/**
 * ChatGateway is an Interface Adapter class responsible for reading from and
 * writing to the serialized files that correspond to the chat data that is
 * stored.
 *
 * @author Rudy
 * @since 1.0
 */
public class ChatGateway implements ReadWriter {
    /**
     * Retrieves data from a serialized file. In particular,
     * used to retrieve a ChatRepoUseCase object from the database
     * to access the previously existing Chatrooms.
     *
     * @param filepath
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Object readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        //read from file

        ChatRepoUseCase chatRepoUseCase = (ChatRepoUseCase) input.readObject();
        input.close();
        return chatRepoUseCase;
    }

    @Override
    public void saveToFile(String filepath, Object chatRepoUseCase) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Graph
        output.writeObject(chatRepoUseCase);
        output.close();
    }
}
