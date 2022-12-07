package usecases.DataRetrieval;

import Entities.User;
import Entities.UserGraph;
import usecases.ChatUseCases.ChatRepoUseCase;
import usecases.UserGraphReadWriter;

import java.io.IOException;

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
     * this method will update the graph of users with a new User
     *      * @see User
     *      * @see UserGraph
     * @throws RuntimeException throws runtime exception
     * @return                  whether a user with the newName exists
     * @see    User
     * @see    UserGraph
     */
    public static void main(String[] args) {
        UserGraph userGraph1 = new UserGraph();
        ChatRepoUseCase.resetChats();
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        new SaveChats(chatRepoUseCase);
        new SaveGraph(userGraph1);
    }
}