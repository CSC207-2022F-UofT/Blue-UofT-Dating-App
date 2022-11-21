package Entities;

public class ChatroomFactory {
    public Chatroom create(User u1, User u2) {
        return new Chatroom(u1, u2);
    }
}
