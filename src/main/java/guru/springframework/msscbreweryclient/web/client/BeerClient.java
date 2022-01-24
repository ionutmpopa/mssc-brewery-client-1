package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.config.AppProperties;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BeerClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String PUT_BEER_PATH_WITH_RESPONSE_V1 = "/api/v1/beer/response";

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public BeerClient(RestTemplateBuilder restTemplateBuilder, AppProperties appProperties) {
        this.restTemplate = restTemplateBuilder.build();
        this.appProperties = appProperties;
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(appProperties.getApiHost() + BEER_PATH_V1 + UUID.randomUUID(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(appProperties.getApiHost() + BEER_PATH_V1, beerDto);
    }

    public BeerDto saveNewBeerPostForObject(BeerDto beerDto) {
        return restTemplate.postForObject(appProperties.getApiHost() + PUT_BEER_PATH_WITH_RESPONSE_V1, beerDto, BeerDto.class);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(appProperties.getApiHost() + BEER_PATH_V1 + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(appProperties.getApiHost() + BEER_PATH_V1 + uuid.toString());
    }
}
