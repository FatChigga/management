package main.java.iptv.sys.service.impl;

import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.impl.BaseServiceImpl;
import main.java.iptv.core.utils.QueryUtil;
import main.java.iptv.sys.service.SysLogLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysLogLoginServiceImpl
        extends BaseServiceImpl
        implements SysLogLoginService {
    public KendoResult getLogLoginPaged(Map map) {
        KendoResult data = QueryUtil.getRecordsPaged("sysLogLogin.getLogLoginPaged", map);
        return data;
    }

    public List getLogLoginLatest() {
        List list = getDao().selectList("sysLogLogin.getLogLoginLatest");
        return list;
    }
}
