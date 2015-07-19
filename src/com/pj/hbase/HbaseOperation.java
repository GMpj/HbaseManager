package com.pj.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * hbase的操作，一般来说，删除数据和删除表使用该类
 * 写入、查询等操作使用HbaseReader或HbaseWriter
 * @author mpj
 *
 */
public class HbaseOperation {
		HbaseConf hbaseConf = new HbaseConf();
		Configuration configuration = hbaseConf.hbaseConf();
		
		/**
		 * 插入数据
		 * @param tableName 表名
		 * @param rowkey 主键
 		 * @param rowfamily 列族
		 * @param row 列
		 * @param data 数据
		 */
	    public void  insertData(String tableName, String rowkey, 
	    		String rowfamily, String row,  String data) { 
	    	    try {
					HBaseAdmin admin = new HBaseAdmin(configuration);
					if(admin.tableExists(tableName)){
						HTable table=new HTable(configuration, tableName);
			    		// 一个put代表一行数据，再new一个put表示第二行数据,每行一个唯一的rowkey
			    		//此处rowkey为put构造方法中传入的值 
						Put put = new Put(rowkey.getBytes());
			    		// 本行数据的第一列 
			    		put.add(rowfamily.getBytes(), row.getBytes(), data.getBytes());
			    		table.put(put);
//			    		table.close();
//			    		admin.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	} 
	    
	    /**
	     * 根据主键删除数据
	     * @param tablename 表名
	     * @param rowkey 主键
	     */
	     public void deleteRow(String tablename, String rowkey)  { 
	    	    try {
					HBaseAdmin admin = new HBaseAdmin(configuration);
					if(admin.tableExists(tablename)){
						HTable table=new HTable(configuration, tablename);
						Delete delete = new Delete(Bytes.toBytes(rowkey));
			    		table.delete(delete);
//			    		table.close();
//			    		admin.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	     }
	     
	     /**
	      * 根据主键查询信息
	      * @param tableName 表名
	      * @param rowkey 主键
	      * @return
	      */
	     public Result QueryByRowKey(String tableName, String rowkey) { 
	    	 	try {
					HTable table=new HTable(configuration, tableName);
					Get scan = new Get(rowkey.getBytes());
					Result r = table.get(scan);
//					table.close();
					return r;
				} catch (IOException e1) {
					e1.printStackTrace();
					return null;
				}
	     } 
	     
	     /**
	      * 根据列和值检索表
	      * @param tableName 表名
	      * @param family 列族
	      * @param column 列
	      * @param val 值
	      * @return
	      */
	     public  ResultScanner QueryByColumn(String tableName,String family, String column, String val) { 
	         try { 
	        	 HTable table=new HTable(configuration, tableName);
	            // 当列colunm的值为val时进行查询 
	             Filter filter = new SingleColumnValueFilter(Bytes.toBytes(family),Bytes 
	                     .toBytes(column), CompareOp.EQUAL, Bytes 
	                     .toBytes(val)); 
	             Scan s = new Scan(); 
	             s.setFilter(filter); 
	             ResultScanner rs = table.getScanner(s); 
//	             table.close();
	             return rs;
	         } catch (Exception e) { 
	             e.printStackTrace(); 
	             return null;
	         } 
	     } 
	     
	     /**
	      * 删除表
	      * @param tableName 表名
	      */
	     public void dropTable(String tableName) { 
	         try { 
	             HBaseAdmin admin = new HBaseAdmin(configuration); 
	             admin.disableTable(tableName); 
	             admin.deleteTable(tableName); 
//	             admin.close();
	         } catch (MasterNotRunningException e) { 
	             e.printStackTrace(); 
	         } catch (ZooKeeperConnectionException e) { 
	             e.printStackTrace(); 
	         } catch (IOException e) { 
	             e.printStackTrace(); 
	         } 
	     }
	     
	 	
	     
	  
	
	    
}
