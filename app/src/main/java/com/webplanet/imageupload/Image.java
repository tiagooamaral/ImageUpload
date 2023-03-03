package com.webplanet.imageupload;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Image {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new BasicAuthInterceptor("testserver", "testserver"))
            .build();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    String bowlingJson(String player1, String player2) {
        return player1;
    }

    public static void main(String[] args) throws IOException {
        Image example = new Image();
        String json = example.bowlingJson(args[0], args[1]);
        String response = example.post("http://datacenter.webne.com.br:8082/GravaFoto", json);
        System.out.println(response);
    }
}
