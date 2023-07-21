package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import modelo.Cliente;
import vista.*;

public class ArchivoServicio implements IMenu {

	@Override
	public void listarCliente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarCliente() {
		
	}

	@Override
	public void editarDatosCliente(int index, int opcion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarEstadoCliente(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void importarDatos(String ruta) {
		try {
			String path = ruta + "DBClientes.csv";

			File file = new File(path);
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {

				String linea = sc.nextLine();
				StringTokenizer atributo = new StringTokenizer(linea, ",");
				Cliente cliente = new Cliente();

				while (atributo.hasMoreElements()) {

					cliente.setRunCliente((atributo.nextElement().toString()));
					cliente.setNombreCliente((atributo.nextElement().toString()));
					cliente.setApellidoCliente((atributo.nextElement().toString()));
					cliente.setAniosCliente((atributo.nextElement().toString()));
					cliente.setCategoriaCliente((atributo.nextElement().toString()));
					listaClientes.add(cliente);


				}
			}

			sc.close();

			listaClientes.forEach(x -> System.out.println(x));
			System.out.println("Datos cargados correctamente en la lista");

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Ruta incorrecta");
		}

	}

	@Override
	public void exportarDatos() {
		
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar:");
		int value = sc.nextInt();
		if(value==1) {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String path = sc.next();
			Exportador exportador = new ExportadorCsv();
			exportador.exportar(path, listaClientes);
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
			
		}else {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String path = sc.next();
			ExportadorTxt exportador = new ExportadorTxt();
			exportador.exportar(path, listaClientes);
			System.out.println("Datos de clientes exportados correctamente en formato txt.");
			
		}
		

	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub

	}

	@Override
	public int tamano() {
		
		return 0;
	}

	@Override
	public void mostrarCliente(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int buscarPorRun(String Run) {
		// TODO Auto-generated method stub
		return 0;
	}

}
