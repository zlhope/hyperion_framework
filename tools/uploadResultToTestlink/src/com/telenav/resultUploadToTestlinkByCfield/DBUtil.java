package com.telenav.resultUploadToTestlinkByCfield;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static Connection connection;
	private static String jdbc = "com.mysql.jdbc.Driver";
	// Stage URL
//	private static String url = "jdbc:mysql://10.224.0.41:3306/testlink";
	// Production URL
	private static String url = "jdbc:mysql://testlink.telenav.com:3306/testlink";
	// readonly user credential
	private static String username = "testlink";
	private static String pwd = "testlink";
	
	public static Connection getConnection() {
		try {
			Class.forName(jdbc);
		} catch (ClassNotFoundException e) {
			System.out.println("Load Driver Exception!");
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url + "?user=" + username
					+ "&password=" + pwd
					+ "&useUnicode=true&characterEncoding=UTF-8");
		} catch (SQLException e) {
			System.out.println("Connnection to DB Exception");
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection4cn() {
		try {
			Class.forName(jdbc);
		} catch (ClassNotFoundException e) {
			System.out.println("Load Driver Exception!");
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url + "?user=" + username
					+ "&password=" + pwd
					+ "&useUnicode=true&characterEncoding=GBK");
		} catch (SQLException e) {
			System.out.println("Connnection to DB Exception");
			e.printStackTrace();
		}
		return connection;
	}

	public static ResultSet getResultByPstmt(String sql, Connection conn) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out
					.println("Result acquisition by prepareStatement Exception");
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getResultByStmt(String sql, Connection conn) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Result acquisition by Statement Exception");
			e.printStackTrace();
		}
		return rs;
	}

	public static int insertDataByPstmt(String sql, Connection conn) {
		int insertRows = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data insert by prepareStatement Exception");
			e.printStackTrace();
		}
		return insertRows;
	}
	
	public static int createAssginments(String sql, int featureID,
			int buildID, int testerID, Connection conn) {
		int insertRows = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, featureID);
			pstmt.setInt(2, testerID);
			pstmt.setInt(3, buildID);
			insertRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data insert by prepareStatement Exception");
			e.printStackTrace();
		}
		return insertRows;
	}

	
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePrepareStatement(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultset(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
