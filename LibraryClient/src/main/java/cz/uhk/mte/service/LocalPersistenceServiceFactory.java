package cz.uhk.mte.service;

import cz.uhk.mte.global.Globals;

public class LocalPersistenceServiceFactory {
	
	private static LocalPersistenceServiceFactory instance = new LocalPersistenceServiceFactory();
	public static LocalPersistenceServiceFactory GetInstance(){
		return instance;
	}
			
	public ILocalPersistenceService GetLocalPersistenceService(){
		
		ILocalPersistenceService service = null;
		switch (Globals.APP_TYPE) {
		case Production:
			service = new LiteDbPersistenceService();
			break;

		case Test:
			//service = TestLocalPersistenceService.GetInstance();
			service = new LiteDbPersistenceService();
			break;
		}
		return service;
	}
}
