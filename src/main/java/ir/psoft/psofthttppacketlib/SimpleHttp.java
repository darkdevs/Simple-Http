package ir.psoft.psofthttppacketlib;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by pouyadark on 10/27/18.
 */

public class SimpleHttp extends Application {
    private static Context context;
    private static String url;
    private static RequestQueue mRequestQueue;

    public static String getUrl() {
        return url;
    }

    public static void setApi(String api){
        Setting.setApi(api);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }

        return mRequestQueue;
    }
    public static Context getInstance() {
        return context;
    }

    public static void initiate(Context contextx,String ServerBaseUrl) {
        SimpleHttp.url = ServerBaseUrl;
        context = contextx;
    }
}
