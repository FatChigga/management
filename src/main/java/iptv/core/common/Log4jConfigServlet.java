
package main.java.iptv.core.common;



import java.io.PrintStream;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import org.apache.log4j.PropertyConfigurator;










@WebServlet({"/Log4jConfigServlet"})
 public class Log4jConfigServlet
 extends HttpServlet
 {
       private static final long serialVersionUID = 1L;



    public void init()
     throws ServletException
 {

        String fileName = getInitParameter("fileName");


        if (fileName != null) {

            PropertyConfigurator.configure(getClass().getClassLoader().getResource(fileName));

        } else {

            System.out.println("===========没有log4j初始化配置文件！==============");

        }

    }

}


