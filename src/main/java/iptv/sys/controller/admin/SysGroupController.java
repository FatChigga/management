package main.java.iptv.sys.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.utils.BaseUtil;
import main.java.iptv.sys.service.SysGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping({"/sys/group"})
public class SysGroupController
        extends AdminBaseController {
    @Resource
    SysGroupService sysGroupService;

    @RequestMapping({"/index"})
    public ModelAndView index() {
        return view();
    }

    @RequestMapping(value = {"/groupNodes"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public List organizationNodes() {
        List data = this.sysGroupService.getALlGroupForNode();
        return data;
    }

    @RequestMapping(value = {"/save"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public Map save(@RequestBody Map map) {
        List<String> messages = new ArrayList();
        Map res = new HashMap();
        try {
            this.sysGroupService.save(map);
        } catch (BizException biz) {
            messages.addAll(biz.getMessages());
        } catch (Exception ex) {
            this.log.error("数据库错误：" + ex.getMessage());
            BaseUtil.saveLog(0, "添加或者修改机构", ex.getMessage());
            messages.add("未知错误。");
        }

        if (messages.size() > 0) {
            res.put("result", Boolean.valueOf(false));
            res.put("message", BaseUtil.toHtml(messages));
        } else {
            res.put("result", Boolean.valueOf(true));
            res.put("message", "保存成功。");
        }

        this.log.info("添加或者修改分组");
        return res;
    }

    @RequestMapping(value = {"/delete"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public Map delete(@RequestBody Map map) {
        List<String> messages = new ArrayList();
        Map res = new HashMap();
        try {
            this.sysGroupService.delete(map);
        } catch (BizException biz) {
            messages.addAll(biz.getMessages());
        } catch (Exception ex) {
            this.log.error("数据库错误：" + ex.getMessage());
            BaseUtil.saveLog(0, "删除机构", ex.getMessage());
            messages.add("未知错误。");
        }

        if (messages.size() > 0) {
            res.put("result", Boolean.valueOf(false));
            res.put("message", BaseUtil.toHtml(messages));
        } else {
            res.put("result", Boolean.valueOf(true));
            res.put("message", "删除成功。");
        }

        this.log.info("删除分组");
        return res;
    }
}
