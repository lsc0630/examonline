package dao;

import java.util.ArrayList;
import java.util.List;

import entiy.User;

public class UserDao extends BaseSql{
	public UserDao() {
		super();
	}
	public List<User> findAll(){
		return findList("select * from tb_user", User.class);
	}
	public User findById(int id){
		return find("select * from tb_user where id="+id, User.class);
	}
	public List<User> findBy(User user){
		StringBuffer sql=new StringBuffer("select * from tb_user where 1=1");
		List<Object> para=new ArrayList<Object>();
		if(user.getName()!=null){
			sql.append(" and name=?");
			para.add(user.getName());
		}
		if(user.getPassword()!=null){
			sql.append(" and password=?");
			para.add(user.getPassword());
		}
		if(user.getRole()!=null){
			sql.append(" and role=?");
			para.add(user.getRole());
		}
		return findList(sql.toString(), User.class, para.toArray());
	}
}
