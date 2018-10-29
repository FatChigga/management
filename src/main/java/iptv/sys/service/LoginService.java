package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface LoginService
        extends BaseService {
    public abstract Map Login(Map paramMap)
            throws BizException;
}
