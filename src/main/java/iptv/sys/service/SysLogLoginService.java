package main.java.iptv.sys.service;

import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysLogLoginService
        extends BaseService {
    public abstract KendoResult getLogLoginPaged(Map paramMap);

    public abstract List getLogLoginLatest();
}
