package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.ResultMapBuilder;

import javax.servlet.http.HttpSession;


@ParentPackage("struts-default")
public class UserAction extends ActionSupport {
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Action(value = "Add",results = {
            @Result(name = "add",location = "/WEB-INF/success.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
    public String Add() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        System.out.println(session.getAttribute("userName"));
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
