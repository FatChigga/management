package main.java.iptv.sys.controller.admin;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.iptv.core.common.BizException;
import main.java.iptv.core.common.Configuration;
import main.java.iptv.core.utils.BaseUtil;
import main.java.iptv.core.utils.EncryptUtil;
import main.java.iptv.sys.service.LoginService;
import main.java.iptv.sys.service.SysLogLoginService;
import main.java.iptv.sys.service.SysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController
        extends AdminBaseController {
    @Resource
    private LoginService loginService;
    @Resource
    SysMenuService sysMenuService;
    @Resource
    SysLogLoginService sysLogLoginService;

    @RequestMapping({"/login"})
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        Random random = new Random();
        Integer num = Integer.valueOf(random.nextInt(999999999));
        try {
            String code = num.toString();
            String codeEnctypt = EncryptUtil.encrypt(code);

            Cookie cookie = new Cookie("code", codeEnctypt);
            response.addCookie(cookie);

            String vcode = String.format("eline2017@!@#*&^2%s", new Object[]{code});
            HttpSession session = request.getSession();
            session.setAttribute("validateCode", vcode);
        } catch (Exception e) {
            this.log.error("生成验证码错误");
            e.printStackTrace();
        }

        this.log.info("访问Controller:admin/login");
        return view("/sys/login");
    }

    @RequestMapping(value = {"/login/doLogin"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public Map doLogin(@RequestBody Map user) {
        List<String> messages = new ArrayList();
        Map res = new HashMap();
        try {
            this.loginService.Login(user);
        } catch (BizException biz) {
            messages.addAll(biz.getMessages());
        } catch (Exception ex) {
            this.log.error("错误信息：" + ex.getMessage());
            BaseUtil.saveLog(0, "用户登录", ex.getMessage());
            messages.add("未知错误。");
        }

        if (messages.size() > 0) {
            res.put("result", Boolean.valueOf(false));
            res.put("message", BaseUtil.toHtml(messages));
        } else {
            res.put("result", Boolean.valueOf(true));
            res.put("message", "登陆成功。");
        }

        this.log.info("用户登录");
        return res;
    }

    @RequestMapping({"/loginout"})
    public ModelAndView loginout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration em = session.getAttributeNames();

        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }

        return redirect("/admin/login");
    }

    @RequestMapping({"/main"})
    public ModelAndView main(HttpServletRequest req) {
        List data = this.sysMenuService.getAllMenus();
        Map map = new HashMap();
        map.put("menus", data);

        HttpSession session = req.getSession();
        Object userName = session.getAttribute("userName");
        map.put("userName", userName);

        this.log.info("访问Controller:admin/main,加载系统菜单");
        return view("sys/main", map);
    }

    @RequestMapping({"/home"})
    public ModelAndView home(HttpServletRequest req) {
        List data = this.sysMenuService.getAllMenus();
        List loginRecord = this.sysLogLoginService.getLogLoginLatest();

        Map res = new HashMap();
        res.put("menus", data);
        res.put("loginRecord", loginRecord);

        this.log.info("访问Controller:admin/main,加载系统菜单");
        return view("sys/home/index", res);
    }

    @RequestMapping({"/test"})
    @ResponseBody
    public Map test() {
        String cfg = Configuration.webCfg.getProperty("sso.server");

        Map map = new HashMap();
        map.put("cfg", cfg);
        return map;
    }
}
