package uk.co.edwardquixote.Zalego.GoogleVolleyIntro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edEnterURL;

    private TextView txtResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

    }


    private void initializeViews() {

        edEnterURL = (EditText) this.findViewById(R.id.edURL);

        txtResponse = (TextView) this.findViewById(R.id.txtRequestResponse);

        Button btnMakeRequest = (Button) this.findViewById(R.id.btnMakeRequest);
        btnMakeRequest.setOnClickListener(MainActivity.this);

    }

    private void makeRequestWithGoogleVolley() {

        String userProvidedUrl = edEnterURL.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.GET, userProvidedUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                txtResponse.setText(response.substring(0, 100));

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                txtResponse.setText(error.toString());

            }

        });

        requestQueue.add(request);

    }


    @Override
    public void onClick(View v) {

        makeRequestWithGoogleVolley();

    }

}
