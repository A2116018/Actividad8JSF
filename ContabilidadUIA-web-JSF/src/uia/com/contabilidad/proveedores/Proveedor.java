package uia.com.contabilidad.proveedores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.ClienteJSF;
import uia.com.contabilidad.clientes.InfoUIA;
import uia.com.contabilidad.cuentas.Cuenta;

public class Proveedor extends InfoUIA
{
	
	Double saldo = 0.0;
	Cuenta miCuenta = null;
	private ArrayList<ClienteJSF> listaJSP = null;
	private ArrayList<String> listaNames = null;
	
	@JsonCreator
    public Proveedor(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("saldo")double p1) 
	{
        super(id, name);
        super.type =  this. getClass(). getSimpleName();        
        this.saldo = p1;
    }

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void validaCobranza() 
	{
			getItems().forEach(t->
	 				{
	 					t.validaCobranza();
		 			}
	 				);
		
	}
	
	public ArrayList<ClienteJSF> getLista() 
	{
		ClienteJSF cliente = null;
		
		if(listaJSP != null)
		{
			((List<ClienteJSF>) listaJSP).clear();
		}
		else
			listaJSP = new ArrayList<ClienteJSF>();
		
		if (this.items != null) 
		{
        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getClienteJSP() != null)
    				((List<ClienteJSF>) listaJSP).add(t.getClienteJSP());
            });
		}
		return listaJSP;
	}

	public ArrayList<ClienteJSF> getListaCuentas() 
	{
		ClienteJSF cliente = null;
		
		if(listaJSP != null)
		{		
			listaJSP = new ArrayList<ClienteJSF>();
		}
		
		if (this.items != null) 
		{        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getItems() != null)
    			{
    				t.getItems().forEach(p->
    				{
    					((List<ClienteJSF>) listaJSP).add(p.getClienteJSP());
    				});
    			}
    		});
		}
		return listaJSP;
	}

	public ArrayList<String> getListaNames() 
	{
		ClienteJSF cliente = null;
		
		if(listaNames == null)
		{		
			listaNames = new ArrayList<String>();
		}
		else
			listaNames.clear();
		
		if (this.items != null) 
		{        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getItems() != null)
    			{
    				t.getItems().forEach(p->
    				{
    					((List<String>) listaNames).add(p.getClienteJSP().getName());
    				});
    			}
    		});
		}
		return listaNames;
	}

}
