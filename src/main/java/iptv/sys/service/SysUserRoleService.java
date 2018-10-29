package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysUserRoleService
        extends BaseService {
    public abstract List<Map> getAllUserRoleForNode();

    public abstract void doSave(Map paramMap)
            throws BizException;

    public abstract List roleList(Map paramMap);
}
