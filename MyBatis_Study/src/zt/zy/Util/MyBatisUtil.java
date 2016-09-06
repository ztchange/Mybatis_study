package zt.zy.Util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
   
public class MyBatisUtil {

	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "config.xml";
		// ʹ�������������mybatis�������ļ�
		// InputStream is=MyBatisUtil.class.getResourceAsStream(resource);
		// MyBatis ����һ������ Resources �Ĺ����࣬������һЩʵ�÷�������ʹ�� classpath
		// ������λ�ü�����Դ�ļ��������ס�
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�����ļ�ʧ��");
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}

}
