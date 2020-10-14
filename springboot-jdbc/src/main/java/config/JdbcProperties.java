package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jdbc")
@Setter
@Getter
public class JdbcProperties {
	
    private String url;
    
    private String driverClassName;
    
    private String username;
    
    private String password;
}


