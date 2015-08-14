package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import connpool.DBConnPoolMgr;

public class BaseSql{
	protected DBConnPoolMgr dpm;
	protected Connection conn;
	
	
	public BaseSql() {
		dpm=DBConnPoolMgr.getInstance();
	}
	
	public <T> T find(String sql,Class<T> entityClass){
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=dpm.getConnect();
			st=conn.createStatement();			
			rs=st.executeQuery(sql);
			if(rs.next()) return getRow(rs, entityClass);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public <T> List<T> findList(String sql,Class<T> entityClass,Object...para){
		List<T> list=new ArrayList<T>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=dpm.getConnect();
			pst=conn.prepareStatement(sql);
			if(para!=null){
				for(int i=0;i<para.length;i++){
					pst.setObject(i+1, para[i]);
				}
			}
			rs=pst.executeQuery();
			while(rs.next())
			   list.add(getRow(rs,entityClass));
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			dpm.returnConnect(conn);			
		}
		return list;
	}
	
	private <T> T getRow(ResultSet rs,Class<T> entityClass){
		Map<String, Field> map=getMapField(entityClass);
		Set<String> set=map.keySet();
		T c=null;
		try {			
				c=entityClass.newInstance();
				for (String s : set) {
					Field field=map.get(s);
					Object object=rs.getObject(s);
					if(object instanceof Number){
						Number num=(Number) object;
						String type=field.getType().getSimpleName();
						switch(type){
						case "int":case "Integer": object=num.intValue();break;
						case "short":case "Short":object=num.shortValue();break;
						case "long":case "Long":object=num.longValue();break;
						case "float":case "Float":object=num.floatValue();break;
						}						
					}
					field.setAccessible(true);
					field.set(c, object);
				}			
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;
	}
	
	private <T> Map<String, Field> getMapField(Class<T> entityClass){
		Map<String, Field> map=new HashMap<String, Field>();
		Field[] field=entityClass.getDeclaredFields();
		for (Field f : field) {
			map.put(f.getName(), f);
		}
		return map;
	}
}
