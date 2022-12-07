package usecases.ChatUseCases;

import Entities.User;

public class ChatRegRequestModel {
    //packages data that's passed from the presenter to the chat use case
    private User user1;
    private User user2;

    public ChatRegRequestModel(User u1, User u2) {
        this.user1 = u1;
        this.user2 = u2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
