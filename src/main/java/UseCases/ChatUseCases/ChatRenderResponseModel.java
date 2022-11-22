package UseCases.ChatUseCases;

import Entities.Chatroom;

import java.util.ArrayList;

public class ChatRenderResponseModel {
    private final ArrayList<Object> chatrooms;

    public ChatRenderResponseModel(ArrayList<Object> chatrooms) {
        this.chatrooms = chatrooms;
    }
    public ArrayList<Object> getChatrooms() {
        return chatrooms;
    }
}
