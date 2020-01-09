package action;

import model.UserMode;
import com.opensymphony.xwork2.Action;

public class ApiAction {

    private UserMode user;
    public UserMode getUser(){return this.user;}
    public void setUser(UserMode user){this.user = user;}
    public String json() {
        user = new UserMode();
//        user.setId("9");
        user.setUsername("ajax返回json");
        user.setPassword("123456");
        System.out.println("method get call.");
        return Action.SUCCESS;
    }
}
