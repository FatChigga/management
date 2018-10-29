package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface LogService
        extends BaseService {
    public abstract KendoResult getLogPaged(Map paramMap);

    public abstract void deleteLogById(Map paramMap)
            throws BizException;

    public abstract void deleteLogAll()
            throws BizException;
}