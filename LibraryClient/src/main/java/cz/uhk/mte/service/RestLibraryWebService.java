package cz.uhk.mte.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.entity.ReservationAndroid;

public class RestLibraryWebService implements ILibraryWebService {

	String serverUri;
	
	public RestLibraryWebService(String serverUri){
		this.serverUri = serverUri;
	}
	
	@Override
	public ArrayList<CategoryAndroid> getCategoriesByParentCategoryID(
			int parentCategoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoriesByParentCategoryID";
		CategoryAndroid[] result = restTemplate.postForObject(url, parentCategoryID, CategoryAndroid[].class);
		return new ArrayList<CategoryAndroid>(Arrays.asList(result));
	}

	@Override
	public ArrayList<CategoryAndroid> getCategoriesBySearchExpression(
			String searchExpression) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoriesBySearchExpression";
		CategoryAndroid[] result = restTemplate.postForObject(url, searchExpression, CategoryAndroid[].class);
		return new ArrayList<CategoryAndroid>(Arrays.asList(result));
	}

	@Override
	public BookAndroid getBookByID(int bookID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBookByID";
		BookAndroid result = restTemplate.postForObject(url, bookID, BookAndroid.class);
		return result;
	}

	@Override
	public ArrayList<BookAndroid> getBooksByCategoryID(int categoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBooksByCategoryID";
		BookAndroid[] result = restTemplate.postForObject(url, categoryID, BookAndroid[].class);
		return new ArrayList<BookAndroid>(Arrays.asList(result));
	}

	@Override
	public ArrayList<BookAndroid> getBooksBySearchExpression(String searchExpression) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getBooksBySearchExpression";
		BookAndroid[] result = restTemplate.postForObject(url, searchExpression, BookAndroid[].class);
		return new ArrayList<BookAndroid>(Arrays.asList(result));
	}



	@Override
	public int InsertReservation(ReservationAndroid reservation) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "insertReservation";
		int result = restTemplate.postForObject(url, reservation, int.class);
		return result;
		
	}

	@Override
	public CategoryAndroid getCategoryByID(int categoryID) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String url = serverUri + "getCategoryByID";
		CategoryAndroid result = restTemplate.postForObject(url, categoryID, CategoryAndroid.class);
		return result;
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

