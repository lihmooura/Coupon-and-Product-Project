package com.candpapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.candpapp.model.Coupon;
import com.candpapp.util.ConnectionUtil;

public class CouponDAO {

	public void save(Coupon coupon) {

		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into coupon (code,discount,exp_date) values(?, ? ?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
