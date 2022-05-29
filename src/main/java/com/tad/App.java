package com.tad;

import com.tad.dto.UserInfoDto;
import com.tad.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * App
 *
 * @author liubin
 * @date 2022/5/29
 */
public class App {

    public static void main(String[] args) throws IOException {
        // 加载mybatis框架主配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取解析配置文件内容，创建SqlSessionFacory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行数据库操作
        UserInfoDto userInfoDto = mapper.getUserById(1);
        // List<Employee> list = mapper.getEmp1();
        System.out.println(userInfoDto);
        sqlSession.commit();
        sqlSession.close();
    }


}
