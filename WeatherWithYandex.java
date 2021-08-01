package JKDZ6;

import okhttp3.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;

public class WeatherWithYandex {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegments("v2/forecast")
                .build();

        //URL url = new URL("https://api.weather.yandex.ru/v2/forecast");

        //Не могу понять, что не так, но ответ получаю - Response{protocol=http/1.1, code=403, message=Forbidden,
        // url=https://api.weather.yandex.ru/v2/forecast}
        //гуглила, читала api яндекса, так и не смогла разобраться

        String body = " lat=<59.57>\n" +
                " & lon=<30.19>\n" +
                " & [lang=<ru_RU>]\n" +
                " & [limit=<5>]\n" +
                " & [hours=<false>]\n" +
                " & [extra=<false>]";

        RequestBody requestBody = RequestBody.create(body, MediaType.parse("JSON"));

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("X-Yandex-API-Key", "546e6bd3-d16c-45e2-aff8-bc4f0039f356")
                .post(requestBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
