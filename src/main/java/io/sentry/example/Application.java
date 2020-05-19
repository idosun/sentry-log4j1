package io.sentry.example;

import io.sentry.Sentry;
import io.sentry.event.Breadcrumb.Level;
import io.sentry.event.Breadcrumb.Type;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.Event;
import io.sentry.event.UserBuilder;
import io.sentry.event.helper.ShouldSendEventCallback;


import org.apache.log4j.Logger;



public class Application {

    static final Logger logger = Logger.getLogger("example.application");
    


    public static void main(String[] args) {
    	initSentry();
    	   	
    	 
        try {
            int example = 1 / 0;
            
        } catch (Exception e) {
            // caught exception that will be sent to Sentry
            logger.error("Caught exception!", e);
        }
        
    }
    
    private static void initSentry() {
//    	Sentry.init();
//        
//    	Sentry.getStoredClient().setServerName("fe1");
//    	
//    	//Added as tags to Sentry event
//        Sentry.getStoredClient().addTag("dynamicTag1", "1.0");
//        
//        Sentry.getStoredClient().addShouldSendEventCallback(new ShouldSendEventCallback() {
//		    @Override
//		    public boolean shouldSend(Event event) {
//		    	 
//		        if (event.getMessage().contains("foo")) {
//		            return false;
//		        }		   
//		
//		        return true;
//		    }
//		});
    }
}
