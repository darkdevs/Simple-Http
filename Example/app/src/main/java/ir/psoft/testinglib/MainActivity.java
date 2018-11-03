package ir.psoft.testinglib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ir.psoft.psofthttppacketlib.SimpleHttp;
import ir.psoft.psofthttppacketlib.SimpleHttpCall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleHttp.initiate(this,"https://reqres.in/api/");
        new test().send();
    }
}
class test extends SimpleHttpCall{
    public test() {
        Url="users?page=2";
        Method=SimpleHttpCall.GET;
    }

    @Override
    protected void OnSuccess(String Response) {
        Log.e("res",Response);
    }
}