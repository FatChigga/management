
package main.java.iptv.core.common;



import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.springframework.web.servlet.HandlerInterceptor;
 import org.springframework.web.servlet.ModelAndView;



 public class CORSInterceptor
 implements HandlerInterceptor
 {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
     throws Exception
 {

        response.addHeader("Access-Control-Allow-Origin", "*");


        return true;

    }



    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
     throws Exception
 {
    }



    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
     throws Exception
 {
    }

}


