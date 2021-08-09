package JKDZ7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {

    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "sB7vcznQ7hqHZPQ5AJq4xezsaIUj0raL";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrlForOneDay = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestForOneDay = new Request.Builder()
                        .url(httpUrlForOneDay)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(requestForOneDay).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                //System.out.println(weatherResponse);
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение

                WeatherResponse weatherResponseFoOneDay = objectMapper.readValue(weatherResponse,WeatherResponse.class);
                System.out.println(weatherResponseFoOneDay);
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
                break;
            case FIVE_DAYS:
                //TODO*: реализовать вывод погоды на 5 дней
                HttpUrl httpUrlForFiveDay = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFoFiveDay = new Request.Builder()
                        .url(httpUrlForFiveDay)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFoFiveDay).execute();
                String weatherResponseForFiveDay = fiveDayForecastResponse.body().string();
                System.out.println(weatherResponseForFiveDay);
                break;
        }
    }

    private String detectCityKey(String selectCity) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}
