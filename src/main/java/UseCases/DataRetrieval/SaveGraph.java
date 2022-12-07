package UseCases.DataRetrieval;
import Entities.UserGraph;
import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.UserGraphReadWriter;
import java.io.IOException;

/**
 * Saves the which is passed into its constructor to the file "userGraph.ser"
 */
public class SaveGraph {

    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    public SaveGraph(UserGraph userGraph) {
        try {
            readWriter.saveToFile("userGraph.ser", userGraph);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
    }

    /**
     * Sets userGraph.ser and chats.ser to a new UserGraph and ChatRepoUseCase
     */
    public static void main(String[] args) {
        UserGraph userGraph1 = new UserGraph();
        ChatRepoUseCase.resetChats();
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        new SaveChats(chatRepoUseCase);
        new SaveGraph(userGraph1);
    }
}