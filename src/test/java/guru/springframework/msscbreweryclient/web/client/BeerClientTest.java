package guru.springframework.msscbreweryclient.web.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient beerClient;

    @Autowired
    ObjectMapper objectMapper;

    @Disabled
    @Test
    void getBeerById() {
        BeerDto dto = beerClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Disabled
    @Test
    void testSaveNewBeer() {

        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Ursus").build();

        URI uri = beerClient.saveNewBeer(beerDto);

        assertNotNull(uri);

        log.info(uri.toString());

    }

    @Disabled
    @Test
    void testSaveNewBeerPostForObject() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Ursus").beerStyle("PALE").upc(5L).build();
        BeerDto beerDtoSaved = beerClient.saveNewBeerPostForObject(beerDto);
        assertNotNull(beerDtoSaved);
        assertThat(beerDtoSaved.getBeerName(), is("Ursus"));
        log.info(beerDtoSaved.toString());
    }

    @Disabled
    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Ursus").beerStyle("PALE").upc(5L).build();
        beerClient.updateBeer(UUID.randomUUID(), beerDto);

    }

    @Disabled
    @Test
    void testDeleteBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Ursus").beerStyle("PALE").upc(5L).build();
        beerClient.deleteBeer(beerDto.getId());

    }
}
