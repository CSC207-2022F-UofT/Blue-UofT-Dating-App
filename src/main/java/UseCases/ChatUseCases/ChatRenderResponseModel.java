package UseCases.ChatUseCases;

import java.util.ArrayList;

/**
 * Response model that is returned by the render method in ChatRenderUseCase
 */
public class ChatRenderResponseModel {


    private final ArrayList<ArrayList<ArrayList<String>>> chatrooms;

    /**
     * Constructor that initilizes the chatrooms attribute to the argument
     * @param chatrooms string representation of the hashmap of Chatroom entities and Messages
     */
    public ChatRenderResponseModel(ArrayList<ArrayList<ArrayList<String>>> chatrooms) {
        this.chatrooms = chatrooms;
    }

    /**
     * Returns the chatrooms attribute
     */
    public ArrayList<ArrayList<ArrayList<String>>> getChatrooms() {
        return chatrooms;
    }
}
