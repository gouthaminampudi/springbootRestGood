//package webApplication;
//
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by kishorejavvaji on 2/16/17.
// * Used to configure servlets and servlet url's
// * You can also configure servlet path in properties file. Hence this ServletRegistration is redundant
// */
//@Configuration
//public class WebConfiguration {
//
//    @Bean
//    ServletRegistrationBean h2servletRegistration() {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*"); //Configuring H2 in memory servlet mapping
//        return registrationBean;
//    }
//
//}
