package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.ResultMapBuilder;

import javax.servlet.http.HttpSession;
import model.UserMode;
import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;


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
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("dao");
//        UserMode userMode = new UserMode();
//        userMode.setUsername(username);
//        userMode.setPassword(password);
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserMode userMode = new UserMode();
        userMode.setUsername(getUserName());
        userMode.setPassword(getPassword());
        userMode.setCreatetime(new Date(new java.util.Date().getTime()));
        boolean result = dao.addStu(userMode);
        Map<String, String> map = new HashMap<String, String>();
        if (result){
            map.put("flag","success");
//            model.addAttribute("users", dao.queryAll());
        }else{
            map.put("flag","failed");
        }
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
