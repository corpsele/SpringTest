package action;

import model.UserMode;
import com.opensymphony.xwork2.Action;
import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class ApiAction {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    private UserMode user;
    public UserMode getUser(){return this.user;}
    public void setUser(UserMode user){this.user = user;}
    public String json() {
        user = new UserMode();
//        user.setId("9");
        if (username==null){
            user.setUsername("ajax返回json");
        }else{
            user.setUsername(username);
        }
        if (password==null){
            user.setPassword("123456");
        }else{
            user.setPassword(password);
        }

        user.setCreatetime(new Date(new java.util.Date().getTime()));

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("dao");
        dao.addStu(user);

        System.out.println("method get call.");
        return Action.SUCCESS;
    }
}
