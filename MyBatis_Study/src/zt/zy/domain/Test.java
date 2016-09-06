/**
 * 
 */
package zt.zy.domain;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
        //mybatis�������ļ�
        String resource = "config.xml";
        //MyBatis ����һ������ Resources �Ĺ����࣬������һЩʵ�÷�������ʹ�� classpath ������λ�ü�����Դ�ļ��������ס�
        InputStream is=Resources.getResourceAsStream(resource);
        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //Reader reader = Resources.getResourceAsReader(resource); 
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "zt.zy.mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����һ��Ψһuser�����sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }

}
