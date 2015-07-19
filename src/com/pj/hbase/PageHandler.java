package com.pj.hbase;

import java.util.List;

import org.apache.hadoop.hbase.client.ResultScanner;
import com.pj.bean.User;

/**
 * 分页处理
 * 
 * @author hadoop
 *
 */
public class PageHandler {

	PageOperation po = new PageOperation();
	ListMapping lm = new ListMapping();

	/**
	 * 日志分页
	 * 
	 * @param uid
	 * @param row
	 * @param num
	 * @return
	 */
	public List<User> logPage(String uid, String row, int num) {
		ResultScanner rs = po.logPageHandler(row, uid, num);
		return lm.userListMapping(rs);
	}

}
