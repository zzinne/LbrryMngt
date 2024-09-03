package star.bucks.framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import star.bucks.framework.config.RootAppContext;
import star.bucks.framework.config.ServletAppContext;
import star.bucks.framework.security.SecurityConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ServletAppContext.class);


        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher",new DispatcherServlet(applicationContext));

        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        rootContext.register(RootAppContext.class, SecurityConfig.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);

        servletContext.addListener(contextLoaderListener);
    }
}
