package servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
@Controller
@RequestMapping("/lists")
public class ListUserController {
    public String getUserName1() {
        return userName1;
    }

    public void setUserName(String userName1) {
        this.userName1 = userName1;
    }

    private String userName1;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    private String password1;

    @RequestMapping("/list")
    public String list (String userName1, String password1){
        System.out.println(userName1);
        System.out.println(password1);
        System.out.println("spring mvc");
        return "success";
    }
}
