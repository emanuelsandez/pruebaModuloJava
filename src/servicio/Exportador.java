package servicio;

import java.util.*;
import modelo.*;


public abstract class Exportador {
	private String path;
//	public List<Cliente> listaClientes;
//
//	public Exportador(String path, List<Cliente> listaClientes) {
//		super();
//		this.path = path;
//		this.listaClientes = listaClientes;
//	}

	public Exportador() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

//	public List<Cliente> getListaClientes() {
//		return listaClientes;
//	}
//	
	

//	@Override
//	public String toString() {
//		return "Exportador [path=" + path + ", listaClientes=" + listaClientes + "]";
//	}
//
//	public void setListaClientes(List<Cliente> listaClientes) {
//		this.listaClientes = listaClientes;
//	}

	public abstract void exportar(String path, List<Cliente> listaClientes);
}
