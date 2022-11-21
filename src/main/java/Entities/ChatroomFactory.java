package Entities;

public class ChatroomFactory {
    public Chatroom create(User user1, User user2) {
        return new Chatroom(user1, user2);
    }
}
