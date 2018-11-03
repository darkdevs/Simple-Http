# Simple-Http
Simply make http requests 

## install
Main build.gradle
```
buildscript {
    
    repositories {
        jcenter()
    }
}
```
App build.gradle
```
compile 'com.dpouya:Simple-http-request:0.1'
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
