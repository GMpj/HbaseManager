package com.pj.test;

import java.io.IOException;
import java.util.List;

import com.pj.bean.User;
import com.pj.hbase.CreateHbase;
import com.pj.hbase.HbaseReader;
import com.pj.hbase.HbaseWriter;

import junit.framework.TestCase;

public class Test extends TestCase{
/**
 * 测试创建表
 */
//	public void testCreat(){
//		//创建用户表
//		String name3 = "user";
//		String[] column1 = {"attr",  "grade"};
//		CreateHbase.createTable(name3, column1);
//	}
///**
// * 测试插入数据
// */
//	public void testInsert(){
//		User user=new User();
//		user.setId("123");
//		user.setName("pj");
//		user.setAge("20");
//		user.setChinese("90");
//		user.setMath("80");
//		user.setSex("男");
//		HbaseWriter writer=new HbaseWriter();
//		writer.putUserBean(user);
//	User user1=new User();
//	user1.setId("1234");
//	user1.setName("pj");
//	user1.setAge("20");
//	user1.setChinese("70");
//	user1.setMath("60");
//	user1.setSex("女");
//	writer.putUserBean(user1);
//	}
/**
 * 测试更新数据
 */
//	public void testUpdate(){
//		User user=new User();
//		user.setId("123");
//		user.setName("pj");
//		user.setAge("20");
//		user.setChinese("90");
//		user.setMath("90");
//		user.setSex("男");
//		HbaseWriter writer=new HbaseWriter();
//		writer.putUserBean(user);
//	}
	/**
	 * 测试从id读取用户信息
	 */
//	public void testReadId(){
//		String id="123";
//		HbaseReader reader=new HbaseReader();
//		User user=reader.getUserId(id);
//		user.toString();
//	}
	/**
	 * 测试通过名字获取用户信息
	 */
//	public void testReadName(){
//		String name="pj";
//		HbaseReader reader=new HbaseReader();
//		try {
//			List<User> users= reader.getUserName("attr", "name", name);
//			for(User user:users){
//				user.toString();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	/**
//	 * 测试根据id删除用户数据
//	 */
//	public void testDelete(){
//		String id="123";
//		HbaseWriter writer=new HbaseWriter();
//		writer.deleteUserBean(id);
//	}
	/**
	 * 删除表
	 */
public void testDrop(){
	String table="user";
	HbaseWriter writer=new HbaseWriter();
	writer.deleteTable(table);
}
}
