package com.pj.hbase;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.junit.Test;

import com.pj.bean.User;

/**
 * 读取hbase内容封装到Bean中
 * @author hadoop
 *
 */
public class HbaseReader {

	HbaseOperation ho = new HbaseOperation();
	BeanMapping bm = new BeanMapping();
	ListMapping lm = new ListMapping();
/**
 * 根据列值获取多条信息
 * @param family
 * @param column
 * @param value
 * @return
 * @throws IOException
 */
	@Test
	public List<User> getUserName(String family, String column,
			String value) throws IOException {
		ResultScanner rs = ho.QueryByColumn("user", family, column,value);
		return lm.userListMapping(rs);
	}

	/**
	 * 根据rowkey 用户名 读取数据保存在UserBean
	 * @param rowkey   用户名uid
	 * @return 如果存在则返回UserBean，不存在返回null
	 */
	@Test
	public User getUserId(String rowkey) {
		Result rs = ho.QueryByRowKey("user", rowkey);
		return bm.userBeanMapping(rs, rowkey);
	}

	
	
	
	



}
