package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface SysPermisionComponentService
        extends BaseService {
    public abstract KendoResult getPermisionComponentPaged(Map paramMap);

    public abstract Map getPermisionComponentById(Map paramMap);

    public abstract void updatePermisionComponent(Map paramMap)
            throws BizException;

    public abstract void deletePermisionComponent(Map paramMap)
            throws BizException;
}


