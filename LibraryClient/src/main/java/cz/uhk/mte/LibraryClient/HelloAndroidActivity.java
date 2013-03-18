package cz.uhk.mte.LibraryClient;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import cz.uhk.mte.model.Pokus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "LibraryClient";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        
        
        Button btShow = (Button) findViewById(R.id.btShowPokus);
        btShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
				restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
				// The URL for making the GET request
				final String url = "http://localhost:8080/mte/getPokusy";

				// Initiate the HTTP GET request, expecting an array of State
				// objects in response
				Pokus[] result = restTemplate.getForObject(url, Pokus[].class);
//						getForObject(url,
//				    PostalCodes.class, this.postalCode, this.countryCode,
//				    this.radius);
				Log.i(TAG,"sysout z ADT"+result);
			}
		});
    }

}

