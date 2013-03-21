package cz.uhk.mte.LibraryClient;


import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


import cz.uhk.mte.model.Pokus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class HelloAndroidActivity extends Activity {

	private static String TAG = "LibraryClient";

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
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
				PokusyTask pt = new PokusyTask();
				pt.execute();
			}
		});
	}

	private class PokusyTask extends AsyncTask<Void, Void, Pokus[]> {

		@Override
		protected Pokus[] doInBackground(Void... params) {
//			RestTemplate restTemplate = new RestTemplate();
//			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//			String url = "http://10.0.2.2:8080/mte/getPokus";
//			Pokus result = restTemplate.getForObject(url, Pokus.class);
//			return result;
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			String url = "http://10.0.2.2:8080/mte/getPokusy";
			Pokus[] result = restTemplate.getForObject(url, Pokus[].class);
			return result;
			
		}
		
		@Override
		protected void onPostExecute(Pokus[] result) {
			// TODO Auto-generated method stub
			for (Pokus pokus : result) {
				Log.i(TAG, "sysout z ADT" + pokus);
			}
		}
		
		
	}

}
