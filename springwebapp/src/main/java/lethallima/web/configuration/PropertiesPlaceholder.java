package lethallima.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by LethalLima on 7/19/16.
 */
@Configuration
@PropertySource({"classpath:jdbc.properties",
        "classpath:test.prop.properties",
        "classpath:hibernate.properties"
})
public class PropertiesPlaceholder {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${build.timestamp}")
    private String timestamp;

    @Value("${build.version}")
    private String version;

    @Value("${hibernate.show_sql}")
    private boolean hibernateShowSql;

    @Value("${hibernate.format_sql}")
    private boolean hibernateFormatSql;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getVersion() {
        return version;
    }

    public boolean isHibernateShowSql() {
        return hibernateShowSql;
    }

    public boolean isHibernateFormatSql() {
        return hibernateFormatSql;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }

    // Required in order to use @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
