package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface SysPermisionService
        extends BaseService {
    public abstract KendoResult getPermisionPaged(Map paramMap);

    public abstract Map findPermisionById(Map paramMap);

    public abstract void update(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;
}
