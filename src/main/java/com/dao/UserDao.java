package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;
import com.service.UserServices;

@Repository
public class UserDao implements UserServices {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int addUser(UserBean userBean) {

		return jdbcTemplate.update("insert into user(uname,uemail,upassword,uage)values(?,?,?,?)", userBean.getuName(),
				userBean.getuEmail(), userBean.getuPassword(), userBean.getuAge());
	}

	private final static class UserMapper implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setuId(rs.getInt("uid"));
			userBean.setuName(rs.getString("uname"));
			userBean.setuEmail(rs.getString("uemail"));
			userBean.setuPassword(rs.getString("upassword"));
			userBean.setuAge(rs.getInt("uage"));
			return userBean;
		}

	}

	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from user", new UserMapper());
	}

}
