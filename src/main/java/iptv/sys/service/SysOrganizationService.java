package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysOrganizationService
        extends BaseService {
    public abstract List<Map> getALlOrganizationsForNode();

    public abstract void save(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;

    public abstract KendoResult getOrgOptions(Map paramMap);
}


