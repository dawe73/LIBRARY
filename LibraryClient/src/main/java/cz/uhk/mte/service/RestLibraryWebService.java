package cz.uhk.mte.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import android.util.Log;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.entity.ReservationAndroid;

public class RestLibraryWebService implements ILibraryWebService {

	String serverUri;
	
	public RestLibraryWebService(String serverUri){
		this.serverUri = serverUri;
		
		System.setProperty("http.keepAlive", "false"); 
	}
	
	@Override
	public ArrayList<CategoryAndroid> getCategoriesByParentCategoryID(
			int parentCategoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoriesByParentCategoryID";
		
		try {
			Log.e("REST", "getCategoriesByParentCategoryID ");	
			CategoryAndroid[] result = restTemplate.postForObject(url, parentCategoryID, CategoryAndroid[].class);
			return new ArrayList<CategoryAndroid>(Arrays.asList(result));
		} catch (RestClientException e) {
			Log.e("REST", "getCategoriesByParentCategoryID " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<CategoryAndroid>();
		}
	}

	@Override
	public ArrayList<CategoryAndroid> getCategoriesBySearchExpression(
			String searchExpression) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoriesBySearchExpression";
		
		try {
			Log.e("REST", "getCategoriesBySearchExpression ");
			CategoryAndroid[] result = restTemplate.postForObject(url, searchExpression, CategoryAndroid[].class);
			return new ArrayList<CategoryAndroid>(Arrays.asList(result));
		} catch (RestClientException e) {
			Log.e("REST", "getCategoriesBySearchExpression " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<CategoryAndroid>();
		}
	}

	@Override
	public BookAndroid getBookByID(int bookID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBookByID";
		
		try {
			Log.e("REST", "getBookByID ");
			BookAndroid result = restTemplate.postForObject(url, bookID, BookAndroid.class);
			return result;
		} catch (RestClientException e) {
			Log.e("REST", "getBookByID " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<BookAndroid> getBooksByCategoryID(int categoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBooksByCategoryID";
		try {
			Log.e("REST", "getBooksByCategoryID ");
			BookAndroid[] result = restTemplate.postForObject(url, categoryID, BookAndroid[].class);
			return new ArrayList<BookAndroid>(Arrays.asList(result));
		} catch (RestClientException e) {
			Log.e("REST", "getBooksByCategoryID " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<BookAndroid>();
		}
	}

	@Override
	public ArrayList<BookAndroid> getBooksBySearchExpression(String searchExpression) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBooksBySearchExpression";
		
		try {
			Log.e("REST", "getBooksBySearchExpression ");
			BookAndroid[] result = restTemplate.postForObject(url, searchExpression, BookAndroid[].class);
			return new ArrayList<BookAndroid>(Arrays.asList(result));
		} catch (RestClientException e) {
			Log.e("REST", "getBooksBySearchExpression " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<BookAndroid>();
		}
	}



	@Override
	public int InsertReservation(ReservationAndroid reservation) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "insertReservation";
		int result;
		try {
			Log.e("REST", "InsertReservation " + Integer.toString(reservation.getBookID()));
			result = restTemplate.postForObject(url, reservation, int.class);
		} catch (RestClientException e) {
			Log.e("REST", "InsertReservation " + e.getMessage());
			e.printStackTrace();
			result = -1;
		}
		return result;
		
	}

	@Override
	public CategoryAndroid getCategoryByID(int categoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoryByID";
		try {
			Log.e("REST", "getCategoryByID ");
			CategoryAndroid result = restTemplate.postForObject(url, categoryID, CategoryAndroid.class);
			return result;
		} catch (RestClientException e) {
			Log.e("REST", "getCategoryByID " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	//@Override
	//public ArrayList<BookAndroid> getAllBook() {
	//	RestTemplate restTemplate = new RestTemplate();
	//	restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
	//	String url = "http://10.0.2.2:8080/mte/getAllBook";
	//	BookAndroid[] result = restTemplate.getForObject(url, BookAndroid[].class);
	//	return new ArrayList<BookAndroid>(Arrays.asList(result));
	//}
}

