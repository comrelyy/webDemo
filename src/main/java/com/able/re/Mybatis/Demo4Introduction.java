package com.able.re.Mybatis;

import com.relyy.VO.QuestionnaireVo;
import com.relyy.VO.UserVO;
import com.relyy.dao.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Mybatis 入门实例
 *
 * @author cairuirui
 * @create 2018/10/25
 */
public class Demo4Introduction {

    public static void main(String[] args) throws Exception{
        //maven 项目中resource目录中的文件的位置
        String resource = "mybatis-config.xml";
        // 读取资源文件
        InputStream stream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获取SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //UserVO userVO = (UserVO) sqlSession.selectOne("com.relyy.dao.TestMapper.selectById", 2);
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        UserVO userVO = mapper.selectById(2);
        System.out.println(userVO);
        //QuestionnaireVo questionnaire = mapper.getQuestionnaire(1);
//        QuestionnaireVo questionnaireLazy = mapper.getQuestionnaireLazy(1);
//
//        //设置懒加载时,不需要相关对象时，不会执行查询语句
//        //懒加载机制实现原理是：通过代理对象来实现的，第一次获得的结果对象就是一个代理对象，当需要是在通过执行指定的方法获取懒加载的对象
//        System.out.println(questionnaireLazy.getClass());//设置懒加载之后，通过打印class对象，可以发现是一个代理对象
//        System.out.println(questionnaireLazy.getComment());

        //System.out.println(questionnaireLazy.getUser());
//        System.out.println(questionnaireLazy.getUser().toString());
        sqlSession.close();



    }
}
