package com.hcmus.bo;

import java.sql.SQLException;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import com.hcmus.util.DBConnectionUtil;

public class CustomSystemEventListener implements SystemEventListener {
	
	@Override
	public boolean isListenerForSource(Object value) {
		//only for Application
		return (value instanceof Application);
	}
	
	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
        if(event instanceof PostConstructApplicationEvent){
            System.out.println("Application Started. PostConstructApplicationEvent occurred!");
            
        }
        if(event instanceof PreDestroyApplicationEvent){
            System.out.println("PreDestroyApplicationEvent occurred. Application is stopping.");
            
            //close connection
            try {
				DBConnectionUtil.openConnection().close();
				System.out.println("Close connection!!!!");
			} catch (SQLException e) {
				System.out.println("Error closing connection!!!!");
			}
        }
    }
}