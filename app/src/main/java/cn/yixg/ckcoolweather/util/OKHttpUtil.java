package cn.yixg.ckcoolweather.util;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Anry on 2019/9/9.
 */
public class OKHttpUtil {

    public static void sendOkHttpRequest(String address, Callback callback) {


        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(address).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }

}
