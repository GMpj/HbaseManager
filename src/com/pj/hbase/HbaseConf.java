package com.pj.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration; 

/**
 * hbase 数据库连接配置
 * @author hadoop
 *
 */
public class HbaseConf {
		/**
		 * hbase配置，因本机hbase配置不同可能需要修改
		 * @return
		 */
		public Configuration hbaseConf(){
			Configuration configuration  = HBaseConfiguration.create(); 
	        configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	        configuration.set("hbase.zookeeper.quorum", "localhost:2181 "); 
	        configuration.set("hbase.master", "localhost"); 
	        return configuration;
		}
}
