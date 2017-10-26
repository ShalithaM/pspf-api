package org.pspf.data;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.pspf.consts.Urls;

public class CallManagerBank {

private static  WebTarget rootTarget = null;
	
	public static WebTarget getRootTarget() {
		if(rootTarget == null) {
			try {
				final Client client = ClientBuilder.newBuilder()
						.build();
						
				rootTarget = client.target(Urls.BANK_API);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rootTarget;
	}

}
