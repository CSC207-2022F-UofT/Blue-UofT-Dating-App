package UseCases.DataRetrieval;

import InterfaceAdapters.ChatGateway;
import UseCases.ChatUseCases.ChatRepoUseCase;

public class GetChats {
    public GetChats(){
        ChatGateway chatGateway = new ChatGateway();
        try{
            ChatRepoUseCase chatRepoUseCase = chatGateway.readFromFile("chats.ser");}
        catch(Exception e){
            System.out.println("Couldnt find chatrooms");
        }
    }
}
