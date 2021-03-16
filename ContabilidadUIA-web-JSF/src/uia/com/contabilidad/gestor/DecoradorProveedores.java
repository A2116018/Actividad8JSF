package uia.com.contabilidad.gestor;

import java.util.ArrayList;

import model.ClienteJSF;
import uia.com.contabilidad.clientes.InfoUIA;

public class DecoradorProveedores extends Decorador {
	
	public DecoradorProveedores(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorProveedores()
	{		
	}
	
	public void validaProveedores()
	{
		super.Print();
	}

	public ArrayList<ClienteJSF> getLista()
	{
		return super.getLista();
	}


	public ArrayList<String> getListaNames() {
		return super.getListaNames();
	}
}
