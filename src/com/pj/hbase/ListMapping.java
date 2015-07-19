package com.pj.hbase;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import com.pj.bean.User;

/**
 * 将数据库读出的数据映射到List
 * 
 * @author mpj
 *
 */
public class ListMapping {

	/**
	 * 将数据库读出的数据映射到UserBean的List
	 * 
	 * @param rs
	 * @return
	 */
	public List<User> userListMapping(ResultScanner rs) {
		List<User> list = new ArrayList<User>();
		for (Result r : rs) {
			User u = new User();
			u.setId(new String(r.getRow()));
			for (Cell cell : r.rawCells()) {
				String v = new String(CellUtil.cloneQualifier(cell));
				String val = new String(CellUtil.cloneValue(cell));
				if (v.equals("name")) {
					u.setName(val);
				}
				if (v.equals("sex")) {
					u.setSex(val);
				}
				if (v.equals("age")) {
					u.setAge(val);
				}
				if (v.equals("chinese")) {
					u.setChinese(val);
				}
				if (v.equals("math")) {
					u.setMath(val);
				}
			}
			list.add(u);
		}
		rs.close();
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

}
