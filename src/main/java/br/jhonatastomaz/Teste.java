package br.jhonatastomaz;

import java.util.List;

import br.jhonatastomaz.implementations.managers.WhmcsBuilder;
import br.jhonatastomaz.implementations.models.enums.InvoiceStatus;
import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.IItemInvoice;
import br.jhonatastomaz.interfaces.IWhmcs;

public class Teste {
   
	public static void main(String[] args) {
		
		
	
		System.out.println("Iniciando");
		long d = System.currentTimeMillis();
		WhmcsBuilder builder = new WhmcsBuilder("https://dashboard.cloudconnect.net.br/includes/api.php", "FizgdXypf0rHt5Sz4eNCLsObCfZhs8gk","abdXxQQX0E9uRwzmN2UloVrotqWx4EHC");
		IWhmcs whmcs = builder.build();
		/* System.out.println("Consultando WHMCS");
		   List<IInvoice>invoices = whmcs.getClientManager().getClientByEmail("jhonatas@gmail.com").getInvoiceManager().getInvoicesByStatus(InvoiceStatus.Unpaid);
		   System.out.println("Consulta Realizada");
		   if(invoices == null) {
				//System.out.println("Sem Faturas para: "+client.getFirstName()+" e:"+client.getEmail());
				//stop();
				 System.out.println("Sem Fatura");
				 
				//continue;
			}
			
			invoices.forEach(i->{
				
				System.out.println("-----------------------");
				System.out.println("ID: "+i.getId());
				IClient c= i.getClient();
				System.out.println("CLient"+i.getClient().getEmail());
				if(!c.hasCustomField(9)) {
					System.out.println("SEM DC");
				}else {
					System.out.println(c.getCustomField(9));
				}
				
				System.out.println("DATA: "+i.getDueDate());
				System.out.println("Status: "+i.getStatus());
				System.out.println("User: ");
				System.out.println("----------------------");
			});
		
		/*
		 * 
		 * 
		w.getInvoiceManager().getInvoicesByStatus(InvoiceStatus.Unpaid).forEach(i->{
		
			IClient c= i.getClient();
			
			if(c.hasCustomField(9) && !(c.getCustomField(9) == null) &&  !(c.getCustomField(9).isEmpty())) {
				System.out.println("user: "+i.getId()+" C: "+c.getEmail());
				System.out.println(i.getTotal()+" STATUS: "+i.getStatus()+" ID: "+c.getCustomField(9));
				System.out.println("Data de vencimento"+i.getDueDate());
				System.out.println("--------");
			//	System.out.println("CLient "+i.getClient().getEmail());
				//System.out.println("SEM DC");
			}
		});*/
		//System.out.println("TESTE: "+(w.getUserManager().getUsers()==null));
		// w.getUserManager().getUserById(0);
		
		//System.out.println("TESTE: "+(w.getInvoiceManager().getInvoicesByStatus(InvoiceStatus.Umpaid)==null));
		//IClient c =w.getClientManager().getClientByEmail("harturbeltramello6@gmail.com");
		//System.out.println("ID: "+c.getId());
		//List<IInvoice>i= w.getClientManager().getClientByEmail("harturbeltramello6@gmail.com").getInvoiceManager()//.getInvoices();//getServiceManager().getServices();
		//i.get(0).getInvoiceDetails().getItemsInvoice();
		  List<IInvoice>invoices = whmcs.getInvoiceManager().getInvoicesByStatus(InvoiceStatus.Unpaid);
		  System.out.println("Faturas Não Pagas: "+invoices.size());
		  int carac = 0;
		  int caracI=0;
		  for(IInvoice i:invoices) {
			  
				System.out.println("-----------------------");
				System.out.println("ID: "+i.getId());
				IClient c= i.getClient();
				System.out.println("CLient"+i.getClient().getEmail());
				if(!c.hasCustomField(9)) {
					System.out.println("SEM DC");
				}else {
					System.out.println(c.getCustomField(9));
				}
				
				System.out.println("DATA: "+i.getDueDate());
				System.out.println("Status: "+i.getStatus());
				String it = "";
				int b=0;
				for(IItemInvoice item :i.getInvoiceDetails().getItemsInvoice()) {
					
					it+= item.getDescription()+" \n ";
					b = item.getDescription().length();
					if(b>carac) {
						carac=item.getDescription().length();
					}
					b+=carac;
					
				}
				
				if(b>caracI) {
					caracI=b;
				}
				
				System.out.println(it);
				System.out.println("User: ");
				
				System.out.println("----------------------");
		  }
		  System.out.println("MAX caraqcters: "+carac);
		  System.out.println("MAX caraqcters De itens: "+caracI);
		long a = System.currentTimeMillis();
		System.out.println("Total: "+(a-d)+" ms");
	}
   
}
