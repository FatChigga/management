package main.java.iptv.core.service.impl;

import main.java.iptv.core.dao.BasicDao;
import main.java.iptv.core.service.BaseService;
import main.java.iptv.core.utils.BaseUtil;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;


@Service
public class BaseServiceImpl
        implements BaseService {
    public SqlSessionTemplate getDao() {
        BasicDao basicDao = (BasicDao) BaseUtil.getService("basicDao");
        SqlSessionTemplate sqlSession = basicDao.getSqlSessionTemplate();

        return sqlSession;
    }

    public Logger log = Logger.getLogger(getClass());
}