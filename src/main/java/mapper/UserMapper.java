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
            userMode.setPassword(rs.getString(2));
            userMode.setUsername(rs.getString(1));
        }catch (Exception e) {
            e.printStackTrace();
        }



        return userMode;
    }

}

