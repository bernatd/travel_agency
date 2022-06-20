package pl.bernatd.travel_agency.hotels.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HotelsConfig {
    @Value("${rapid.api.hotels.url}")
    private String hotelsApiEndpoint;
    @Value("${rapid.api.hotels.key}")
    private String hotelsKey;
    @Value("${rapid.api.hotels.host.name}")
    private String hotelsHostName;
}
