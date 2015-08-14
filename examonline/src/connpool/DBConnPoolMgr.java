package connpool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DBConnPoolMgr {
	private String driver;
	private String url;
	private String user;
	private String pass;
	private ObjectPool connPool;
	private static DBConnPoolMgr dbcpm;
	
	public DBConnPoolMgr() {
		driver="oracle.jdbc.driver.OracleDriver";
		url="jdbc:oracle:thin:@localhost:1521:xe";
		user="exam";
		pass="123";
		InitConnectPool();
	}
	
	public static DBConnPoolMgr getInstance(){
		if(dbcpm==null){
			dbcpm=new DBConnPoolMgr();
		}
		return dbcpm;
	}
	
	private void InitConnectPool(){
		try {
			Class.forName(driver);
			connPool=new GenericObjectPool(null,100);
			ConnectionFactory connFactory=new DriverManagerConnectionFactory(url, user, pass);
			new PoolableConnectionFactory(connFactory, connPool, null, null, false, true);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动");
		}
	}
	public Connection getConnect() throws SQLException {
		try {
			return (Connection) connPool.borrowObject();
		} catch (Exception e) {
			throw new SQLException("数据库连接错误：" + e.getMessage());
		}

	}
	public void returnConnect(Connection conn) {
		try {
			connPool.returnObject(conn);
		} catch (Exception e) {
			System.out.println("return connect object error ");
		}
	}
}
