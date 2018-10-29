package main.java.iptv.sys.service.impl;

import java.util.Map;

import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.impl.BaseServiceImpl;
import main.java.iptv.core.utils.QueryUtil;
import main.java.iptv.sys.service.SysLogVisitService;
import org.springframework.stereotype.Service;


@Service
public class SysLogVisitServiceImpl
        extends BaseServiceImpl
        implements SysLogVisitService {
    public KendoResult getLogVisitPaged(Map map) {
        KendoResult data = QueryUtil.getRecordsPaged("sysLogVisit.getLogVisitPaged", map);
        return data;
    }
}
