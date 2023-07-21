package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.*;



public interface IMenu {
	
	List<Cliente> listaClientes = new ArrayList<Cliente>();	
	Scanner sc = new Scanner(System.in);
	
	
	public void listarCliente();
	public void agregarCliente();
	public void editarDatosCliente(int index, int opcion);
	public void editarEstadoCliente(int index);
	public void importarDatos(String ruta);
	public void exportarDatos();
	public void terminarPrograma();
	public int tamano();
	public void mostrarCliente(int index);
	public int buscarPorRun(String run);
}
