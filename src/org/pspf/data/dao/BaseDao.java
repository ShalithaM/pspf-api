package org.pspf.data.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.pspf.data.MysqlDbConnManager;

public class BaseDao {
	
	public Connection getConnection() {
		return MysqlDbConnManager.MANAGER.getConnection();
	}
	
	/**
	 * @param conn
	 */
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
