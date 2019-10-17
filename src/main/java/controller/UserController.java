package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.UserMode;
import dao.UserDao;

import java.lang.reflect.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     *
     * 从数据库中获取全部学生信息，将数据返回给主页index,jsp
     *
     * @param model
     * @return 返回值类型： String
     * @author janinus
     */
    @RequestMapping("/getall")
    @ModelAttribute("userModel")
    public String queryAll(Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //从ioc容器中获取dao
        UserDao dao = (UserDao) context.getBean("dao");
        model.addAttribute("users", dao.queryAll());
//        model.addAttribute("tops", dao.topNum(3));
        return "success";
    }

    /**
     * 通过姓名查找学生，使用模糊查找，将结果返回给index.jsp
     *
     * @param name
     * @param model
     * @return 返回值类型： String
     * @author janinus
     */
    @RequestMapping(value = "/queryByName")
    public String queryByName(String name, Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //从ioc容器中获取dao
        UserDao dao = (UserDao) context.getBean("dao");
        model.addAttribute("users", dao.queryByName(name));
        model.addAttribute("tops", dao.topNum(3));
        return "index.jsp";
    }

    /**
     * 添加新学生，并将结果返回给all页面，由all转发到主页
     * @param userMode
     * @return 返回值类型： String
     * @author janinus
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addStu(@RequestBody UserMode userMode, Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("dao");
//        UserMode userMode = new UserMode();
//        userMode.setUsername(username);
//        userMode.setPassword(password);
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        userMode.setCreatetime(new Date(new java.util.Date().getTime()));
        boolean result = dao.addStu(userMode);
        Map<String, String> map = new HashMap<String, String>();
        if (result){
           map.put("flag","success");
           model.addAttribute("users", dao.queryAll());
        }else{
            map.put("flag","failed");
        }

//            model.addAttribute("msg", "<script>alert('添加成功！')</script>");
//        else
//            model.addAttribute("msg", "<script>alert('添加成功！')</script>");
        return map;
    }

    /**
     * 通过id删除学生
     * @param id
     * @param model
     * @return 返回值类型： String
     * @author janinus
     */
    @RequestMapping(value = "/deleteById")
    public String deleteById(String id, Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("dao");
        boolean result = dao.deleteStu(Integer.parseInt(id));
        if (result)
            model.addAttribute("msg", "<script>alert('删除成功！')</script>");
        else
            model.addAttribute("msg", "<script>alert('删除成功！')</script>");
        return "all";
    }

    /**
     *
     * @param id
     * @param username
     * @param password
     * @param model
     * @return 返回值类型： String
     * @author janinus
     */
    @RequestMapping(value = "/update")
    public String updateStu(String id, String username, String password,  Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("dao");
        UserMode userMode = new UserMode();
        userMode.setUsername(username);
        userMode.setPassword(password);
        boolean result = dao.updateStu(userMode);
        if (result)
            model.addAttribute("msg", msg("修改成功"));
        else
            model.addAttribute("msg", msg("修改失败"));
        return "all";
    }

    /**
     * 要弹出的页面消息
     * @param msg
     * @return 返回值类型： String
     * @author janinus
     */
    public String msg(String msg) {
        return "<script>alert('" + msg + "')</script>";
    }

    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public UserDao getDao() {
        return dao;
    }
}