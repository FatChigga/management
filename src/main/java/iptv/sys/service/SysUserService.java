package main.java.iptv.sys.service;


import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.BaseService;

import java.util.Map;

public abstract interface SysUserService
  extends BaseService
{
  public abstract KendoResult getUserPaged(Map paramMap);
  
  public abstract Map findUserById(Map paramMap);
  
  public abstract void save(Map paramMap)
    throws Exception;
  
  public abstract void delete(Map paramMap)
    throws BizException;
  
  public abstract void passwordModiy(Map paramMap)
    throws Exception;
  
  public abstract KendoResult findAllUser(Map paramMap);
}
