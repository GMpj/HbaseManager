package com.pj.hbase;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import com.pj.bean.User;

/**
 * 将数据库读出的数据映射到Bean
 * @author mpj
 *
 */
public class BeanMapping {


	
	/**
	 * 将数据库读出的数据映射到User
	 * @param rs
	 * @param rowkey
	 * @return
	 */
	public User userBeanMapping(Result rs,String rowkey){
		User ub = new User();
		if (rs.isEmpty()) {
			return null;
		} else {
			ub.setId(rowkey);
			for(Cell cell:rs.rawCells()){
				String v = new String(CellUtil.cloneQualifier(cell));
				String val = new String(CellUtil.cloneValue(cell));
				if (v.equals("name")) {
					ub.setName(val);
				}
				if (v.equals("sex")) {
					ub.setSex(val);
				}
				if (v.equals("age")) {
					ub.setAge(val);
				}
				if (v.equals("chinese")) {
					ub.setChinese(val);
				}
				if (v.equals("math")) {
					ub.setMath(val);
				}
				
			}
		}
		return ub;
		
	}
	
	
}
