package usecases.user_register_use_case;

public class UserRegResponseModel {
    String login;
    public UserRegResponseModel(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
