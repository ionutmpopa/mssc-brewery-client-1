package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.config.AppProperties;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder, AppProperties appProperties) {
        this.restTemplate = restTemplateBuilder.build();
        this.appProperties = appProperties;
    }

    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(appProperties.getApiHost() + CUSTOMER_PATH_V1 + UUID.randomUUID(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(appProperties.getApiHost() + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(appProperties.getApiHost() + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(appProperties.getApiHost() + CUSTOMER_PATH_V1 + uuid.toString());
    }
}
