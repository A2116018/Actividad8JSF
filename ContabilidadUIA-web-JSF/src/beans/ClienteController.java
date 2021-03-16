package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import model.ClienteJSF;
import uia.com.contabilidad.ContabilidadUIA;

@ManagedBean(name = "clienteController")
@SessionScoped
public class ClienteController {
	
	private ContabilidadUIA dao = new ContabilidadUIA();
	
	public ArrayList<ClienteJSF> compras = null;
	public ArrayList<ClienteJSF> proveedores = null;
	public ArrayList<String> proveedoresNames = null;
	public ArrayList<String> comprasNames = null;
	public ArrayList<ClienteJSF> listaNotaDebito = null;
	public ClienteJSF proveedor = null;
			
	public ArrayList<String> getProveedoresNames() {
		
		if(this.proveedores != null)
			proveedor = this.proveedores.get(0);
		else
		{
			this.proveedores = this.dao.getListaProveedores();
			proveedor = this.proveedores.get(0);
		}

		proveedoresNames=this.dao.getProveedoresNames();
		return proveedoresNames;
	}

	public ArrayList<String> getComprasNames() {
		if(this.proveedor == null)
		{
			this.proveedores = this.dao.getListaProveedores();
			proveedor = this.proveedores.get(0);			
		}
		comprasNames=this.dao.getComprasNames(this.proveedor.getName());
		return comprasNames;
	}
	
	
	
	public void setProveedoresNames(ArrayList<String> proveedoresNames) 
	{
		this.proveedoresNames = proveedoresNames;
	}


	
	
	
	public ClienteController() {
		
		this.listaNotaDebito = this.dao.getCheques(null);
		
		

		
	}
	

	public ClienteJSF getProveedor() {
		return proveedor;
	}

	public void setProveedor(ClienteJSF proveedor) {
		this.proveedor = proveedor;
	}

	public void setComprasNames(ArrayList<String> comprasNames) {
		this.comprasNames = comprasNames;
	}

	public ArrayList<ClienteJSF> getCompras() {
		return this.dao.listaCompras;
	}

	public ArrayList<ClienteJSF> getProveedores() {
		return this.dao.listaProveedores;
	}

	public void setProveedores(ArrayList<ClienteJSF> proveedores) {
		this.proveedores = proveedores;
	}

	public void setCompras(ArrayList<ClienteJSF> compras) {
		this.compras = compras;
	}
	
	public void onEdit(RowEditEvent event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }
	
	public void onCancel(RowEditEvent event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }

	public void onRowSelect(SelectEvent event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }
	
}
