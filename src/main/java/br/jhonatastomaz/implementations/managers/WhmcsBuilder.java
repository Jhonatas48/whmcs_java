package br.jhonatastomaz.implementations.managers;

import br.jhonatastomaz.interfaces.IWhmcs;
import br.jhonatastomaz.interfaces.IWhmcsBuilder;

public class WhmcsBuilder implements IWhmcsBuilder{

	private WHMCSApi api = null;
	private String identifier = null;
	private String secret = null;
	private String url = null;
	private boolean useOldAutentication = false;
	
	
	public WhmcsBuilder(String url,String identifier,String secret) {
	
		this.identifier = identifier;
		this.secret = secret;
		
		this.useOldAutentication= false;
		if(url == null || url.isEmpty()) {
			throw new NullPointerException("url is null");
		}
		this.url = getValidURL(url);
		if(identifier == null || identifier.isEmpty()) {
			throw new NullPointerException("idenfier is null");
		}
		
		if(secret == null || secret.isEmpty()) {
			throw new NullPointerException("secret is null");
		}
		api = new WHMCSApi(url,identifier,secret);
	}

    
	public WhmcsBuilder(boolean useOldAutentication,String url,String adminusername, String password) {
		
		this.identifier = adminusername;
		this.secret = password;
		
		this.useOldAutentication = useOldAutentication;

		if(url == null || url.isEmpty()) {
			throw new NullPointerException("url is null");
		}
		this.url = getValidURL(url);
		if(identifier == null || identifier.isEmpty()) {
			throw new NullPointerException("adminusername is null");
		}
		
		if(secret == null || secret.isEmpty()) {
			throw new NullPointerException("adminusername is null");
		}
		
		api = new WHMCSApi(useOldAutentication, url, adminusername, password);
	}
   
	private static String getValidURL(String url) {
		if(url == null) {
			return null;
		}
		
        if (!url.endsWith("/")) {
            url += "/";
        }

        if (!url.contains("include/api.php")) {
            url += "include/api.php";
        }

        return url;
    }

	public IWhmcs build() {
		
		
		if(api == null) {
			throw new NullPointerException("Configure the builder first");
		}
		
		return new Whmcs(api);
	}

}
