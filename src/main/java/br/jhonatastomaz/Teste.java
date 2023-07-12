package br.jhonatastomaz;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.ClientDesserializer;
import br.jhonatastomaz.desserializer.ProductDesserealizer;
import br.jhonatastomaz.desserializer.ServiceDesserializer;
import br.jhonatastomaz.implementations.managers.Whmcs;
import br.jhonatastomaz.implementations.managers.WhmcsBuilder;
import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.implementations.models.Product;
import br.jhonatastomaz.implementations.models.Service;
import br.jhonatastomaz.implementations.models.enums.InvoiceStatus;
import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.IWhmcs;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetClientsPayload;
import me.hwiggy.whmjava.payload.g.GetClientsProductsPayload;
import me.hwiggy.whmjava.payload.g.GetProductsPayload;

public class Teste {
   
	public static void main(String[] args) {
		
		
	
		System.out.println("Iniciando");
		long d = System.currentTimeMillis();
		WhmcsBuilder builder = new WhmcsBuilder("https://dashboard.cloudconnect.net.br/includes/api.php", "FizgdXypf0rHt5Sz4eNCLsObCfZhs8gk","abdXxQQX0E9uRwzmN2UloVrotqWx4EHC");
		IWhmcs w = builder.build();
		System.out.println("TESTE: "+(w.getUserManager().getUsers()==null));
		 w.getUserManager().getUserById(0);
		
		//System.out.println("TESTE: "+(w.getInvoiceManager().getInvoicesByStatus(InvoiceStatus.Umpaid)==null));
		//IClient c =w.getClientManager().getClientByEmail("harturbeltramello6@gmail.com");
		//System.out.println("ID: "+c.getId());
		//List<IInvoice>i= w.getClientManager().getClientByEmail("harturbeltramello6@gmail.com").getInvoiceManager()//.getInvoices();//getServiceManager().getServices();
		//i.get(0).getInvoiceDetails().getItemsInvoice();
		long a = System.currentTimeMillis();
		System.out.println("Total: "+(a-d)+" ms");
	}
   
}
