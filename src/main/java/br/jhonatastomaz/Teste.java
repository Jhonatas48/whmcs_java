package br.jhonatastomaz;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.ClientDesserializer;
import br.jhonatastomaz.desserializer.ProductDesserealizer;
import br.jhonatastomaz.desserializer.ServiceDesserializer;
import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.implementations.models.Product;
import br.jhonatastomaz.implementations.models.Service;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetClientsPayload;
import me.hwiggy.whmjava.payload.g.GetClientsProductsPayload;
import me.hwiggy.whmjava.payload.g.GetProductsPayload;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WHMCS w = new WHMCS("https://dashboard.cloudconnect.net.br/includes/api.php", "FizgdXypf0rHt5Sz4eNCLsObCfZhs8gk","abdXxQQX0E9uRwzmN2UloVrotqWx4EHC");
        Payload p = new GetClientsPayload().withLimitnum(150);
        
        
        try {
			JSONObject jsonObject = w.submitPayload(p);
			if(jsonObject ==null) {
				System.out.print("vazio");
				return;
			}
			JSONObject clientObjects=  jsonObject.getJSONObject("clients");
			JSONArray clientsArray = clientObjects.getJSONArray("client");
			//clientsArray.length()
			
			for(int i =0;i<clientsArray.length();i++) {
				JSONObject clientObject = clientsArray.getJSONObject(i);
				Client c = ClientDesserializer.deserializeClients(clientObject);
				
				System.out.println("Id: "+c.getId());
				System.out.println("Nome: "+c.getFirstName());
				System.out.println("Email: "+c.getEmail());
				
				p = new GetClientsProductsPayload().withClientID(c.getId());
				System.out.println("------------------------------");
				
				JSONObject json = w.submitPayload(p);
				if(json ==null || json.getInt("totalresults") == 0) {
					continue;
				}
				
				JSONObject serviceObjects = json.getJSONObject("products"); // Corrigido: use o objeto "json" em vez de "jsonObject"
				JSONArray serviceArray = serviceObjects.getJSONArray("product"); // Corrigido: use o objeto "serviceObjects" em vez de "clientObjects"

				 
				for(int j =0;i<serviceArray.length();i++) {
					JSONObject serviceObject = serviceArray.getJSONObject(i);
					Service s =ServiceDesserializer.deserializeService(serviceObject);
					System.out.println("Id: "+s.getId());
					System.out.println("Nome: "+s.getName());
					System.out.println("Status: "+s.getStatus());
					System.out.println("----------------------------");
				}
				
				
				System.out.println("----------------------------");
				System.out.println("=====================");
				
			}
			
			p = new GetProductsPayload();
			jsonObject =  w.submitPayload(p);
			JSONObject products = jsonObject.getJSONObject("products");
			JSONArray productsArray = products.getJSONArray("product");
			System.out.println("=====================");
			System.out.println("=====================");
			System.out.println("Produtos");
			for(int i =0;i<productsArray.length();i++) {
				JSONObject ps = productsArray.getJSONObject(i);
			    Product pro =  ProductDesserealizer.desserialize(ps);
				System.out.println("Id: "+pro.getPid());
				System.out.println("Nome: "+pro.getName());
				System.out.println("modulo: "+pro.getModule());
				System.out.println("=====================");
			}
			//ClientDesserializer.deserializeClients(o);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
