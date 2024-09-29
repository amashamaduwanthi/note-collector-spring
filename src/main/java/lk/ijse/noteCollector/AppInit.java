package lk.ijse.noteCollector;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.noteCollector.config.WebAppConfig;
import lk.ijse.noteCollector.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    //multipart form data handle krnne meken
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }
}
