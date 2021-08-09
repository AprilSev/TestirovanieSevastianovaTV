package JKDZ7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty(value = "Data")
    private String date;

    public WeatherResponse(String date) {
        this.date = date;
    }

    public WeatherResponse() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "date='" + date + '\'' +
                '}';
    }
}
