package mapper;

import model.UserMode;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserMode> {

    @Override
    public UserMode mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        UserMode userMode = new UserMode();
        try {
            userMode.setUserid(String.valueOf(rs.getInt(1)));
            userMode.setPassword(rs.getString(3));
            userMode.setUsername(rs.getString(2));
            userMode.setCreatetime(rs.getDate(4));
        }catch (Exception e) {
            e.printStackTrace();
        }



        return userMode;
    }

}

