package FrameworksDrivers;

import Entities.*;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import InterfaceAdapters.ChatGateway;
import InterfaceAdapters.MainPagePresenter;
import InterfaceAdapters.UserLogPresenter;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.CurrentUserGateway;
import InterfaceAdapters.ChatViewPresenter;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.DataRetrieval.SaveChats;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.LikeUseCase;
import UseCases.PracticeGraphCreator;

import javax.swing.*;
import java.awt.*;

public class ViewUI {

    //creates initial frame
    private JFrame frame = new JFrame();
    //master panel
    private JPanel masterPanel = new JPanel();
    private CardLayout layout = new CardLayout();
    private View currView;
    public ViewUI() {
        //master panel
        this.masterPanel.setLayout(layout);
        this.masterPanel.setPreferredSize(new Dimension(600, 800));;
        //initial panel
        UserEditView userEditView = new UserEditView(this.masterPanel, this.layout, new User(null, null));

        OtherAccount otherAccount =  new OtherAccount(this.masterPanel, this.layout);
        LogInView logInView = new LogInView(this.masterPanel, this.layout);
        ChatView chatView = new ChatView(this.masterPanel, this.layout);
        SignUpView signUpView = new SignUpView(this.masterPanel, this.layout);
        MainPageView mainPageView = new MainPageView(this.masterPanel, this.layout);

        currView = logInView;


        // Main Page



//        Send the paths to other pages that your page will have
//        I.E login -> main
        Object[] mainPagePaths = {otherAccount, chatView, userEditView, mainPageView};
        mainPageView.sendPaths(mainPagePaths);
        Object[] otherAccountPaths = {mainPageView};
        otherAccount.sendPaths(otherAccountPaths);
        Object[] userEditPaths = {mainPageView};
        userEditView.sendPaths(userEditPaths);
        Object[] logInPath = {mainPageView,signUpView};
        logInView.sendPaths(logInPath);
        Object[] signUpPath = {userEditView};
        signUpView.sendPaths(signUpPath);

 //       Object[] chatViewPaths = {mainPageView};
  //      chatView.sendPaths(chatViewPaths);

        ////////////////////////////////////////////////////////////////////////////////////////
        UserGraph practicegraph = PracticeGraphCreator.createGraph();
        new SaveGraph(practicegraph);
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(new Username(CurrentGraph.getGraph().getUsernames().get(0)));
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");
        u1.setDisplayName("clark");
        u2.setDisplayName("kevin");
        practicegraph.addUser(u1);
        practicegraph.addUser(u2);
        new SaveGraph(practicegraph);

        Chatroom test1 = new Chatroom(u1, u2);
        test1.addMessage(new Message(u1, "hello joe"));
        test1.addMessage(new Message(u2, "hello bob"));
        ChatRepoUseCase repo = new ChatRepoUseCase();
        repo.addChatroom(test1);
        new SaveChats(repo);
        mainPageView.updatePage(new Object[]{CurrentGraph.getGraph().getUser(currentUser.getUser())});
        LikeUseCase likeUseCase = new LikeUseCase();
        likeUseCase.updateEdge(u2, CurrentGraph.getGraph().getUser(currentUser.getUser()));
        LikeUseCase likeUseCase2 = new LikeUseCase();
        likeUseCase2.updateEdge(u1, CurrentGraph.getGraph().getUser(currentUser.getUser()));
        ///////////////////////////////////////////////////////////////////////////////////////////////

        JScrollPane scroller = new JScrollPane( this.masterPanel);
        this.layout.show(this.masterPanel, "signUpView");
        this.frame.add(scroller);
        this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
        this.frame.setTitle("MainPage");
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setResizable(true);


    }

    public static void main(String[] args) {
        ViewUI UI = new ViewUI();
        ChatViewPresenter presenter = new ChatViewPresenter(UI.currView);
        presenter.render();
    }
}
