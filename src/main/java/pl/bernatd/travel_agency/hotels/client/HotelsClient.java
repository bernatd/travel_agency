package pl.bernatd.travel_agency.hotels.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.bernatd.travel_agency.dto.HotelsApiDto;
import pl.bernatd.travel_agency.hotels.config.HotelsConfig;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HotelsClient {
    @Autowired
    private final HotelsConfig config;
    @Autowired
    private final RestTemplate restTemplate;

    public List<HotelsApiDto> getHotels(String place, String locale, String currency) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", config.getHotelsKey());
        headers.set("X-RapidAPI-Host", config.getHotelsHostName());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> request = new HttpEntity<>(headers);

        URI url = UriComponentsBuilder.fromHttpUrl(config.getHotelsApiEndpoint() + "/locations/v2/search")
                .queryParam("query", place)
                .queryParam("locale", locale)
                .queryParam("currency", currency)
                .build()
                .encode()
                .toUri();

        try {
            ResponseEntity<HotelsApiDto> hotelsResponse = restTemplate.exchange(url, HttpMethod.GET, request, HotelsApiDto.class);
            return Optional.ofNullable(hotelsResponse.getBody())
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (RestClientException e) {
            System.out.println("Caught exception: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
