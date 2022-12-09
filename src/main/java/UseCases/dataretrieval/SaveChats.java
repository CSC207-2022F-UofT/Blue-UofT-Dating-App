package UseCases.dataretrieval;

import InterfaceAdapters.ChatGateway;
import UseCases.chat.ChatRepoUseCase;

public class SaveChats {
    public SaveChats(ChatRepoUseCase chatRepoUseCase){
        ChatGateway chatGateway = new ChatGateway();
        try{chatGateway.saveToFile("chats.ser", chatRepoUseCase);}
        catch(Exception e){
            System.out.println("Could not save Chats");
        }
    }
}
