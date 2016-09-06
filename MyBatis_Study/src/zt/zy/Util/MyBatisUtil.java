package zt.zy.Util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
   
public class MyBatisUtil {

	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "config.xml";
		// 使用类加载器加载mybatis的配置文件
		// InputStream is=MyBatisUtil.class.getResourceAsStream(resource);
		// MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，可使从 classpath
		// 或其他位置加载资源文件更加容易。
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("获取配置文件失败");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}

}
