package sample;

import sourceFiles.UserAccount;

public final class UserInstance {
    private UserAccount user;
    private final static UserInstance INSTANCE = new UserInstance();
    private UserInstance(){}

    public static UserInstance getInstance() {
        return INSTANCE;
    }

    public void setUser(UserAccount u) {
        this.user = u;
    }

    public UserAccount getUser() {
        return this.user;
    }
}
