package za.net.genius.textaparent;

import android.support.v7.app.AppCompatActivity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Compose extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        makePostRequestOnNewThread();

    }

    private void makePostRequestOnNewThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sendSMS();
                }catch (Exception e){

                }
            }
        });
        t.start();
    }
    private void sendSMS(){

        //create HTTP Client
        HttpClient httpClient = new DefaultHttpClient();
        TextView message = (TextView)findViewById(R.id.tvHeader);
        //create HTTP Post
        HttpPost httpPost = new HttpPost("http://api.clickatell.com/http/sendmsg?");

        //build post params
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(5);
        nameValuePair.add(new BasicNameValuePair("user", "ariscent"));
        nameValuePair.add(new BasicNameValuePair("password", "1qazxsw2#EDC"));
        nameValuePair.add(new BasicNameValuePair("api_id", "3555022"));
        nameValuePair.add(new BasicNameValuePair("to", "27729887045"));
        nameValuePair.add(new BasicNameValuePair("text", "Testing test a parent from tablet!"));

        //String request = "http://api.clickatell.com/http/sendmsg?user=ariscent&password=1qazxsw2#EDC&api_id=3555022&to=27720836991&text=Message";

        //encode POST data
        try{
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

        }catch (UnsupportedEncodingException e) {
            //log excption
            e.printStackTrace();
        }

        //making POST request
        try{
            HttpResponse response = httpClient.execute(httpPost);
            //write response to log
            Log.d("Http Response:" , response.toString());
            message.setText("Http Response:" + response.toString());

        }catch (ClientProtocolException e) {
            //lo exception
            e.printStackTrace();
        }catch (IOException e) {
            //log exception
            e.printStackTrace();
        }
    }


}
