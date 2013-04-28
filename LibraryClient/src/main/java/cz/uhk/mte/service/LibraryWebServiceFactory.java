package cz.uhk.mte.service;

import cz.uhk.mte.global.Globals;

public class LibraryWebServiceFactory {

	private static LibraryWebServiceFactory instance = new LibraryWebServiceFactory();
	
	public static LibraryWebServiceFactory GetInstance() {
		return instance;
	}
	
	public ILibraryWebService GetWebService() {
		
		ILibraryWebService service = null;
		
		switch (Globals.APP_TYPE) {
		case Test:
			service = new TestLibraryWebService();
			break;

		case Production:
			service = new RestLibraryWebService(Globals.SERVER_URI);
			break;
		}
		
		return service;
	}
	
}
