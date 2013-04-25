package cz.uhk.mte.webService;

import java.util.ArrayList;
import java.util.Date;


public interface LibraryWebService {


 public ArrayList<CategoryAndroid> getCategoriesByParentCategoryID(int parentCategoryID);
 public ArrayList<CategoryAndroid> getCategoriesBySearchExpression(String searchExpression);

 public BookAndroid getBookByID(int bookID);
 public ArrayList<BookAndroid> getBooksByCategoryID(int categoryID);
 public ArrayList<BookAndroid> getBooksBySearchExpression(String searchExpression);

 public int InsertReservation(int bookID, String name, String surname, String date);
}