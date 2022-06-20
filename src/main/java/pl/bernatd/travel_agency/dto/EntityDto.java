package pl.bernatd.travel_agency.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityDto {

    @JsonProperty("destinationId")
    private String destinationId;

    @JsonProperty("type")
    private String type;

   @JsonProperty("name")
    private String name;
}
