# Simple-Http
Simply make http requests with full controll of result and no need to manange threats

support: pouya.demokri@gmail.com

site: [Www.Dpouya.com](http://www.dpouya.com)

## install
### Main build.gradle
```
buildscript {
    
    repositories {
        jcenter()
    }
}
```
### App build.gradle
```
implementation 'com.dpouya:Simple-http-request:0.1.2'
```

### Permisos / Permissions
Add permissions in `AndroidManifest.xml` file

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
```

## using
### Application.java
```
public class ApplicationLoader extends Application {
   
    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHttp.initiate(this, "http://test.com/apiroot/");
    }
}

```
## simple http call
### getTest.java
```
public class getTest extends SimpleHttpCall {
    public getTest() {
        Url = "gettest.php";
         Method = SimpleHttpCall.POST;//OR SimpleHttpCall.GET
        //for http://test.com/apiroot/gettest.php
    }

    @Override
    protected void OnSuccess(String Response) {
        //override this if results type is String
    }

    @Override
    protected void OnSuccessJson(JSONObject JsonResponse) {
          //override this if results type is JsonObject
    }
    
    @Override
    protected void OnSuccessJsonarray(JSONArray jsonResponse) {
        //override this if results type is jsonarray
    }

    @Override
    protected void OnError(Exception error) {
        //error
    }
}
```

### Using:

```
new getTest().send();
```

## Http call with callback
```
public class getCounts extends SimpleHttpCall {
    public interface OnCountResultInterface{void CountResult(int count);}
    OnCountResultInterface onResultListener;
    public getSeriesDetail(int id,onResultListener listener) {
        Url = "countof.php?id="+id;
        Method = SimpleHttpCall.GET;
        this.onResultListener=listener;

    }

    @Override
    protected void OnSuccessJson(JSONObject JsonResponse) {
        onResultListener.CountResult(JsonResponse.getInt("count"));
    }

    @Override
    protected void OnError(Exception error) {
        super.OnError(error);
        //Log error
    }
}
```

#### Using:
```
new getCounts(102,new getCounts.OnCountResultInterface() {
            @Override
            public void CountResult(int count) {
                Log.e("Count Result","Count :" + count);
            }
        }).send();
 ```
