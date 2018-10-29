package main.java.iptv.core.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class BasicDaoImpl implements BasicDao {
    public SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSession) {
        this.sqlSessionTemplate = sqlSession;
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return this.sqlSessionTemplate;
    }
}
