package com.brave.registration.regist.app;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TelegramHandler {
    public static void sendTelegramMessage(String chatId, String text) {
        OkHttpClient client = new OkHttpClient();
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        //Add Telegram token (given Token is fake)
        String apiToken = "1790354324:AAHlQdCYLfCI5PFZ1HdMGOksFIvkHJWYrOQ";
        urlString = String.format(urlString, apiToken, chatId, text);
        Request request = new Request.Builder()
                .url(urlString)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    final String my_response = response.body().string();
                }
            }
        });
    }
}