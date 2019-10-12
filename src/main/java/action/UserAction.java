package action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    public String Add(){

        System.out.println("add user");
        return "add";
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
