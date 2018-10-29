package main.java.iptv.sys.service;

import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface SysLogVisitService
        extends BaseService {
    public abstract KendoResult getLogVisitPaged(Map paramMap);
}
