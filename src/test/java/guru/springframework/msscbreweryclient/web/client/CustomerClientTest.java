package guru.springframework.msscbreweryclient.web.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Autowired
    ObjectMapper objectMapper;

    @Disabled
    @Test
    void getCustomerById() {
        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Disabled
    @Test
    void testSaveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Ursus").build();

        URI uri = customerClient.saveNewCustomer(customerDto);

        assertNotNull(uri);

        log.info(uri.toString());

    }


    @Disabled
    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Ursus").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Disabled
    @Test
    void testDeleteCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Ursus").build();
        customerClient.deleteCustomer(customerDto.getId());

    }

}
