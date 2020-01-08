package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import mapper.UserMapper;

import model.UserMode;

public class UserDao {

    /**
     * @Fields jdbcTemplate : TODO
     */

    private JdbcTemplate jdbcTemplate;

    /**
     * spring提供的类
     *
     * @param jdbcTemplate
     *      返回值类型： void
     * @author janinus
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询所有学生
     *
     * @return 返回值类型： List<Student>
     * @author janinus
     */
    public List<UserMode> queryAll() {
        String sql = "select id,username,password,createtime from users";
        //将查询结果映射到Student类中，添加到list中，并返回
        return jdbcTemplate.query(sql, new UserMapper());
    }

    /**
     * 通过姓名查询
     *
     * @param name
     * @return 返回值类型： List<Student>
     * @author janinus
     */
    public List<UserMode> queryByName(String name) {
        String sql = "select id,username,password from users where name like '%" + name + "%'";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    /**
     * 添加学生
     *
     * @param userMode
     * @return 返回值类型： boolean
     * @author janinus
     */
    public boolean addStu(UserMode userMode) {
        String sql = "insert into users(username,password,createtime) values(?,?,?)";
        return jdbcTemplate.update(sql,
                new Object[] {userMode.getUsername(), userMode.getPassword(), userMode.getCreatetime()}) == 1;
    }

    /**
     * 删除学生
     *
     * @param id
     * @return 返回值类型： boolean
     * @author janinus
     */
    public boolean deleteStu(Integer id) {
        String sql = "delete from users where id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    /**
     * 更新学生信息
     *
     * @param userMode
     * @return 返回值类型： boolean
     * @author janinus
     */
    public boolean updateStu(UserMode userMode) {
        String sql = "update users set username=? ,password=? where id = ?";
        Object stuObj[] = new Object[] { userMode.getUsername(), userMode.getPassword()};
        return jdbcTemplate.update(sql, stuObj) == 1;
    }

    /**
     * 返回总成绩前n名学生
     *
     * @param num
     * @return 返回值类型： List<Student>
     * @author janinus
     */
    public List<UserMode> topNum(int num) {
        String sql = "select id,username,javaScore+htmlScore+cssScore from users order by javaScore+htmlScore+cssScore desc ,name asc limit ?";
        return jdbcTemplate.query(sql, new RowMapper<UserMode>() {

            @Override
            public UserMode mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                UserMode userMode = new UserMode();

                userMode.setUsername(rs.getString(1));
                userMode.setPassword(rs.getString(2));


                return userMode;
            }
        }, num);
    }

}