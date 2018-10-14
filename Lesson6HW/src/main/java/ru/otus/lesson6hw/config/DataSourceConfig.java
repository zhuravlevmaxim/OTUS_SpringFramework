package ru.otus.lesson6hw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhmv on 23.07.2018.
 */
@Component
@ConfigurationProperties("dbconfig")
public class DataSourceConfig {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private String serverTimeZoneKey;
    private String serverTimeZoneValue;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerTimeZoneKey() {
        return serverTimeZoneKey;
    }

    public void setServerTimeZoneKey(String serverTimeZoneKey) {
        this.serverTimeZoneKey = serverTimeZoneKey;
    }

    public String getServerTimeZoneValue() {
        return serverTimeZoneValue;
    }

    public void setServerTimeZoneValue(String serverTimeZoneValue) {
        this.serverTimeZoneValue = serverTimeZoneValue;
    }
}
