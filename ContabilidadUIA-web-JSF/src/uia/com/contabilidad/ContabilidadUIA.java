package uia.com.contabilidad;

import java.util.ArrayList;

import model.ClienteJSF;
import uia.com.contabilidad.cheques.GestorCheques;
import uia.com.contabilidad.clientes.InfoUIA;
import uia.com.contabilidad.gestor.DecoradorProveedores;
import uia.com.contabilidad.gestor.Gestor;
import uia.com.contabilidad.proveedores.Proveedor;

public class ContabilidadUIA {
		
	    public Gestor contabilidad =  null;
		public DecoradorProveedores gestorProveedores = null;		
		public ArrayList<ClienteJSF> listaProveedores = null;
		public ArrayList<ClienteJSF> listaCuentas = null;
		public ArrayList<ClienteJSF> listaCompras = null;
		public ArrayList<String> listaComprasNames = null;
		public ArrayList<String> listaProveedoresNames = null;
		public ArrayList<String> listaNotaDebito = null;
		public Proveedor proveedor = null;
		public String clienteId="";

		public ContabilidadUIA()
		{
		 contabilidad = new Gestor("C:\\Users\\wenty\\Downloads\\Contabilidad-UIA-web-JSF-master\\ContabilidadUIA-web-JSF\\ListaProveedores.json");		
		 gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");		 
		 gestorProveedores.Print();
		 listaProveedores = gestorProveedores.getLista();
		 GestorCheques gestorCheques = new GestorCheques();
		}
		
		
		public ArrayList<ClienteJSF> getListaProveedores() {
			return listaProveedores;
		}



		public void setListaProveedores(ArrayList<ClienteJSF> listaProveedores) {
			this.listaProveedores = listaProveedores;
		}


		public DecoradorProveedores getGestorProveedores() {
			return gestorProveedores;
		}

		public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
			this.gestorProveedores = gestorProveedores;
		}


		public ClienteJSF getClienteById(String clienteId) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void agregaCliente(String clienteId) {
			
		}


		public void borraCliente(String clienteId) {
			// TODO Auto-generated method stub
			
		}


		public ArrayList<ClienteJSF> getAllClientes() {
			// TODO Auto-generated method stub
			return null;
		}


		public void checkCliente(ClienteJSF cliente) {
			// TODO Auto-generated method stub
			
		}


		public ArrayList<ClienteJSF> getCuentas(String clienteName) 
		{
			this.listaCuentas = proveedor.getListaCuentas();
			return this.listaCuentas;
		}
        

		public ArrayList<ClienteJSF> getCompras(String clienteId) {
			this.clienteId = clienteId;
			proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
			listaCompras = proveedor.getLista();
			return listaCompras;
		}

		public ArrayList<ClienteJSF> getListaCompras(String clienteId) {
			this.clienteId = clienteId;
			getCompras(this.clienteId);
			return listaCompras;
		}


		public ArrayList<ClienteJSF> getCheques(String clienteId2) {
			// TODO Auto-generated method stub
			return null;
		}


		public ArrayList<String> getProveedoresNames() {			
			return gestorProveedores.getListaNames();
		}


		public ArrayList<String> getComprasNames(String clienteId) 
		{
				this.clienteId = clienteId;
				proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
				listaComprasNames = proveedor.getListaNames();
				return listaComprasNames;
		}
		
		
	
		
}
