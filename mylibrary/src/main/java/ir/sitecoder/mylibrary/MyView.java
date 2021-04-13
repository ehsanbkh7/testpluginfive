package ir.sitecoder.mylibrary;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;
public class MyView extends LinearLayout {

    public MyView(Context context) {
        super(context);
        initialize(context);
        try {
            login(context);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
        try {
            login(context);
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }
    private void initialize(Context context){
        Toast.makeText(context,"OK____",Toast.LENGTH_LONG).show();
    }


    public void login(Context c) throws JSONException {
        Toast.makeText(c,"OK____",Toast.LENGTH_LONG).show();
//            StaticInfo.Mobile=edt_mobile.getText().toString();
            AsyncHttpClient client = new AsyncHttpClient();
            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
            RequestParams params = new RequestParams();
            params.put("key", "03d35dPAMQPnv26aalzqi04369gq8adc4");
            params.put("action", "login");
            params.put("username", "test");
            params.put("pass", "1234");
            // params.put("version", StaticInfo.Version);
            client.setTimeout(15000);
            client.setConnectTimeout(15000);
            client.setResponseTimeout(15000);
            client.post("https://chizmizmarket.ir/api/messenger.php", params, new TextHttpResponseHandler() { //new JsonHttpResponseHandler()
                        @Override
                        public void onStart() {
                            super.onStart();
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, String res) {
                            Log.e("MYLIB___", res);

                            JSONArray jsonArray;
                            JSONObject jsonObJ;
                            try {
                                jsonObJ = new JSONObject(res);
                                boolean Ok = jsonObJ.getBoolean("ok");

                            } catch (JSONException e) {
                                Log.v("ERR___",res+"");
                                Log.e("MYLIB___", res);
                            }

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                            Log.e("MYLIB___", "ERRR___");
                        }
                    }
            );

    }



}
