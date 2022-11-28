package UseCases.user_register_use_case;

public class UserRegDsRequestModel {

    private final String name;
    private String password;

    public UserRegDsRequestModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}