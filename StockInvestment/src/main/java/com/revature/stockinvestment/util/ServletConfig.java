/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.util;

import javax.servlet.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(HibernateConfig.class);
        annotationConfigWebApplicationContext.setServletContext(sc);
        ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(annotationConfigWebApplicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
