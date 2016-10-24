package lethallima.web.configuration;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lethallima.web"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    // for jsp
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // for css, and other.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    // for Jackson to acknowledge lazy loading
    private Hibernate4Module hibernate4Module() {
        Hibernate4Module module = new Hibernate4Module();
        // configure Hibernate4Module

        return module;
    }

    // for jackson to build and parse JSON
    private MappingJackson2HttpMessageConverter jacksonMessageConverter(){
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"))
                .modulesToInstall(hibernate4Module());

        return new MappingJackson2HttpMessageConverter(builder.build());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());

        super.configureMessageConverters(converters);
    }

}
