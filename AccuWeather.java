package JKDZ6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuWeather {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/349727")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("apikey", "sB7vcznQ7hqHZPQ5AJq4xezsaIUj0raL")
                .addHeader("language", "en")
                .addHeader("details", "false")
                .addHeader("metric", "false")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }
    // тут такой ответ в итоге: {"fault":{"faultstring":"Failed to resolve API Key variable request.queryparam.apikey",
    // "detail":{"errorcode":"steps.oauth.v2.FailedToResolveAPIKey"}}}
}
