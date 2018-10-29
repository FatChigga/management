
package main.java.iptv.core.common;



import javax.servlet.ServletContextEvent;


 public class JdfServletContextListener implements javax.servlet.ServletContextListener
 {
       private static final String env = System.getenv("JAVA_ENV");





    public void contextDestroyed(ServletContextEvent arg0) {
    }




    public void contextInitialized(ServletContextEvent arg0)
 {

        System.out.println("==========================================");

        System.out.println("| 当前运行模式：" + env + " |");

        System.out.println("==========================================");


        if ((env != null) && (env.equals("production"))) {

            System.setProperty("spring.profiles.active", "production");

        } else if ((env != null) && (env.equals("test"))) {

            System.setProperty("spring.profiles.active", "test");

        } else {

            System.setProperty("spring.profiles.active", "development");

        }

    }

}
