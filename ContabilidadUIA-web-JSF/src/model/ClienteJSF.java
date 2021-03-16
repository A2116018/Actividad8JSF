package model;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import uia.com.contabilidad.clientes.InfoUIA;

public class ClienteJSF {
	private int id;
	private String name;
	private String estado;
	protected String type;
	private ArrayList<String> comprasNames = null;
	private ArrayList<String> listaNotaDebito = null;
	
	
	public ArrayList<String> getComprasNames() {
		return comprasNames;
	}

	public void setComprasNames(ArrayList<String> comprasNames) 
	{
		this.comprasNames = comprasNames;
	}

	public ClienteJSF(String fecha, int id, String status)
	{
		this.id = id;
		this.estado = status;
		
		
	}
	
	public ClienteJSF(String name2, int id2, String estado2, List<InfoUIA> lista) 
	{
		this.id= id2;
		this.name =name2;
		this.estado = estado2;
		
		if(comprasNames != null)
		{
			comprasNames.clear();
		}
		else
			comprasNames = new ArrayList<String>();
		
		if (lista != null) {
            lista.forEach( entry -> {
    			comprasNames.add(entry.getName());    			
            });
        }
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
