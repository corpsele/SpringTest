package action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String Add() {
        System.out.println(getUserName());
        System.out.println(getPassword());
        System.out.println("add user");
        return "add";
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
