package UseCases.ChatUseCases;

import Entities.Chatroom;

import java.util.ArrayList;

public class ChatRenderResponseModel {
    private final ArrayList<ArrayList<ArrayList<String>>> chatrooms;

    public ChatRenderResponseModel(ArrayList<ArrayList<ArrayList<String>>> chatrooms) {
        this.chatrooms = chatrooms;
    }
    public ArrayList<ArrayList<ArrayList<String>>> getChatrooms() {
        return chatrooms;
    }
}
