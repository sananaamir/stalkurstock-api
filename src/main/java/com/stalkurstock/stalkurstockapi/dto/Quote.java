package com.stalkurstock.stalkurstockapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Quote {

    @JsonProperty("c")
    private Double currentPrice;

    @JsonProperty("h")
    private Double highPriceOfTheDay;

    @JsonProperty("l")
    private Double lowPriceOfTheDay;

    @JsonProperty("o")
    private Double openPriceOfTheDay;

    @JsonProperty("p")
    private Double previousClosePrice;

    @JsonProperty("t")
    private long timestamp;

}
