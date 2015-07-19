package com.pj.hbase;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * 分页操作
 * @author hadoop
 *
 */
public class PageOperation {
	
	HbaseConf hbaseConf = new HbaseConf();
	Configuration configuration = hbaseConf.hbaseConf();
	
	/**
	 * 日志分页查询
	 * @param table
	 * @param coloum1
	 * @param rowkey
	 * @param coloum2
	 * @param uid
	 * @param num
	 * @return
	 */
	public ResultScanner logPageHandler( String rowkey, String uid, int num){
		 try { 
			 HTable table=new HTable(configuration, "cloud_log");
	            List<Filter> filters = new ArrayList<Filter>(); 
	 
	            Filter filter1 = new SingleColumnValueFilter(Bytes 
	                    .toBytes("attr"), Bytes .toBytes("time"), 
	                    CompareOp.LESS, Bytes .toBytes(rowkey)); 
	            filters.add(filter1); 
	            
	            Filter filter2 = new SingleColumnValueFilter(Bytes 
	                    .toBytes("attr"), Bytes .toBytes("user"), 
	                    CompareOp.EQUAL, Bytes .toBytes(uid)); 
	            filters.add(filter2); 
	            
	            PageFilter pf = new PageFilter(num);
	            filters.add(pf);
	            
	            FilterList filterList = new FilterList(filters); 
	            Scan scan = new Scan(); 
	            scan.setFilter(filterList); 
	            ResultScanner rs = table.getScanner(scan); 
//	            table.close();
	            return rs;
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	            return null;
	        } 
	}

	
	
}
