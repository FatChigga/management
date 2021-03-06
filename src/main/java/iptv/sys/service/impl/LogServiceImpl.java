package main.java.iptv.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.KendoResult;
import main.java.iptv.core.service.impl.BaseServiceImpl;
import main.java.iptv.core.utils.QueryUtil;
import main.java.iptv.sys.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl
        extends BaseServiceImpl
        implements LogService {
    public KendoResult getLogPaged(Map param) {
        KendoResult data = QueryUtil.getRecordsPaged("log.getLogPaged", param);
        return data;
    }

    public void deleteLogById(Map map) throws BizException {
        List errMsg = new ArrayList();

        if ((map.get("Id") == null) || (((ArrayList) map.get("Id")).size() <= 0)) {
            errMsg.add("请选择要删除的系统日志。");
        }

        if (errMsg.size() > 0) {
            throw new BizException(errMsg);
        }

        getDao().delete("log.deleteLogById", map);
    }

    public void deleteLogAll()
            throws BizException {
        List errMsg = new ArrayList();


        if (errMsg.size() > 0) {
            throw new BizException(errMsg);
        }

        getDao().delete("log.deleteLogAll");
    }
}
