package guru.springframework.msscbreweryclient.web.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Configuration
public class AppProperties {

    private String apiHost;
    private int connectionManagerMaxTotal;
    private int connectionManagerDefaultMaxPerRoute;
    private int connectionRequestTimeout;
    private int socketTimeout;

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public int getConnectionManagerMaxTotal() {
        return connectionManagerMaxTotal;
    }

    public void setConnectionManagerMaxTotal(int connectionManagerMaxTotal) {
        this.connectionManagerMaxTotal = connectionManagerMaxTotal;
    }

    public int getConnectionManagerDefaultMaxPerRoute() {
        return connectionManagerDefaultMaxPerRoute;
    }

    public void setConnectionManagerDefaultMaxPerRoute(int connectionManagerDefaultMaxPerRoute) {
        this.connectionManagerDefaultMaxPerRoute = connectionManagerDefaultMaxPerRoute;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
