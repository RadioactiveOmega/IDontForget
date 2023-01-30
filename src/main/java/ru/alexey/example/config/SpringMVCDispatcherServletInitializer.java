package ru.alexey.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Если в классе возникает ошибка java: cannot access jakarta.servlet.ServletException class file for jakarta.servlet.ServletException not found,
    // переписать зависимость в pom.xml с Java Servlet API на Jakarta Servlet.

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
