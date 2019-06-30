package com.syjpro.util;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	
	private static ComboPooledDataSource ds = null;
	
	static {
		// 核心对象
		ds = new ComboPooledDataSource();
		FileInputStream fis = null;
		try {
			// 读取配置文件
			String path = DBUtil.class.getResource("").getPath();
			path = path + "db.properties";
			// url解码
			path = URLDecoder.decode(path, "utf-8");
//			System.out.println(path);
			Properties prop = new Properties();
			fis = new FileInputStream(new File(path));
			prop.load(fis);
			// 连接池对象配置基本信息
			ds.setDriverClass(prop.getProperty("clsName"));
			ds.setJdbcUrl(prop.getProperty("url"));
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
			// 连接池常见参数配置
			// 初始化连接池大小
			ds.setInitialPoolSize(Integer.parseInt(prop.getProperty("initialPoolSize")));
			// 最小连接数
			ds.setMinPoolSize(30);
			// 最大连接数
			ds.setMaxPoolSize(200);
			// 最大空闲时间，单位为秒
			ds.setMaxIdleTime(60);
			// 无新连接可用时一次性创建连接数
			ds.setAcquireIncrement(5);
		} catch (FileNotFoundException e) {
			System.err.println("配置文件未找到！");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("配置文件加载失败！");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("连接池初始化失败！");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println(con);
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			System.err.println("获取连接失败！");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			System.err.println("关闭连接失败！");
			e.printStackTrace();
		}
	}
	
	
}
