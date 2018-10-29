package main.java.iptv.sys.service;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysRoleMenuService
        extends BaseService {
    public abstract List<Map> getAllRoleMenuForNode();

    public abstract void doSave(Map paramMap)
            throws BizException;

    public abstract List menuList(Map paramMap);
}
