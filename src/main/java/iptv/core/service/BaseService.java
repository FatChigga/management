package main.java.iptv.core.service;

import org.mybatis.spring.SqlSessionTemplate;

public abstract interface BaseService {
    public abstract SqlSessionTemplate getDao();
}

