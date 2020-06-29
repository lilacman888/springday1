package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "spring", "spring123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
