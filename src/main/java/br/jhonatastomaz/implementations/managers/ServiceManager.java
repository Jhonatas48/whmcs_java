package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.ServiceDesserializer;
import br.jhonatastomaz.interfaces.IService;
import br.jhonatastomaz.interfaces.managers.IServiceManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetClientsProductsPayload;

class ServiceManager implements IServiceManager{

	private WHMCSApi api;
	private int clientid;
	public ServiceManager(WHMCSApi api,int clientid) {
		this.api = api;
		this.clientid=clientid;
		if(api == null) {
			throw new NullPointerException("WhmcsAPi is null");
		}
		if(clientid ==0) {
			throw new IllegalArgumentException("ClientId is 0");
		}
	}
	@Override
	public List<IService> getServices() {
		Payload payload = new GetClientsProductsPayload().withClientID(clientid);
		try {
			JSONObject json= api.submitPayload(payload);
			if(json == null || !json.get("result").equals("success")) {
				return null;
			}
			
			if(json.getInt("totalresults") ==0) {
				return null;
			}
			
			JSONObject servicesObjects=  json.getJSONObject("products");
			
			if(servicesObjects == null || servicesObjects.length() == 0) {
				return null;
			}
			
			JSONArray servicesArray = servicesObjects.getJSONArray("product");
			int length =servicesArray.length();
			List<IService>services = new ArrayList<>();
			for(int id=0;id < length;id++) {
				JSONObject serviceObject= servicesArray.getJSONObject(id);
				
				IService  service = ServiceDesserializer.deserializeService(serviceObject);
				services.add(service);
			}
			return services;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
