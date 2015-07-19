package com.pj.hbase;

import org.junit.Test;

import com.pj.bean.User;

/**
 * 将Bean写入hbase
 * 
 * @author mpj
 *
 */
public class HbaseWriter {

	HbaseOperation ho = new HbaseOperation();

	/**
	 * 将用户信息写入user
	 * 
	 * @param ub
	 */
	@Test
	public void putUserBean(User ub) {
		if ((ub == null) || (ub.getId().equals(""))) {
			// 传值有问题，处理一下
			return;
		}

		ho.insertData("user", ub.getId(), "attr", "name", ub.getName());
		ho.insertData("user", ub.getId(), "attr", "sex", ub.getSex());
		ho.insertData("user", ub.getId(), "attr", "age", ub.getAge());
		ho.insertData("user", ub.getId(), "grade", "chinese", ub.getChinese());
		ho.insertData("user", ub.getId(), "grade", "math", ub.getMath());
	}
/**
 * 根据id删除数据
 * @param id
 */
	@Test
	public void deleteUserBean(String id) {
		HbaseOperation operation = new HbaseOperation();
		operation.deleteRow("user", id);
	}
/**
 * 根据表名删除数据表
 * @param table
 */
	@Test
	public void deleteTable(String table) {
		HbaseOperation operation = new HbaseOperation();
		operation.dropTable(table);
	}
}
