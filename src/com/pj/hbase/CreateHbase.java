package com.pj.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.Test;

/**
 * 创建数据库，运行一次就可以列
 * @author mpj
 *
 */
public class CreateHbase {
	static HbaseConf hbaseConf = new HbaseConf();
	static Configuration configuration = hbaseConf.hbaseConf();

	public static void main(String[] args) {
	
		//创建用户表
		String name3 = "user";
		String[] column1 = {"attr",  "grade"};
		createTable(name3, column1);

	}

	/**
	 * 建表
	 * @param tableName 表名
	 * @param column 族列数组
	 */
	@Test
	public static void createTable(String tableName, String[] column) {
		try {
			HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
			// 如果存在要创建的表，不做操作
			if (hBaseAdmin.tableExists(tableName)) {
				System.out.println(tableName + " is exist....");
			} else {
				// 建列族
				HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
				int num = column.length;
				for (int i = 0; i < num; i++) {
					//添加列族
					tableDescriptor.addFamily(new HColumnDescriptor(column[i]));
				}
				hBaseAdmin.createTable(tableDescriptor);
				hBaseAdmin.close();
			}
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
