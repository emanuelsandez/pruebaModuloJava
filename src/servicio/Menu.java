package servicio;

import java.util.Scanner;
import vista.*;
import utilidades.*;


public class Menu {
	public void menu() {
	Scanner sc = new Scanner(System.in);
	IMenu lista = new ClienteServicio();
	
//	List<Cliente> listaClientes = new ArrayList<Cliente>();
//	IjeansDAO utilidad = new Utilidad();

	int op = 0;
	do
	{

		System.out.println("--------------------");
		System.out.println("*********Menú*******");
		System.out.println("1.- Listar Clientes");
		System.out.println("2.- Agregar Cliente");
		System.out.println("3.- Editar Cliente");
		System.out.println("4.- Cargar Datos");
		System.out.println("5.- Exportar Datos");
		System.out.println("6- Salir");
		System.out.println("---------------------");
		System.out.println("Seleccione una opción");

		try {
			op = sc.nextInt();

			switch (op) {
			case 1:
//				Caso 1 listar clientes
				IMenu clienteServicio = new ClienteServicio();
				if (lista.tamano() != 0) {
					clienteServicio.listarCliente();
				} else {
					System.out.println("No existen Clientes");
					break;
				}

				break;
			case 2:
//				agregar cliente
				IMenu crearCliente = new ClienteServicio();
				crearCliente.agregarCliente();
				
				break;

			case 3:
//				editar cliente
				IMenu editarCliente = new ClienteServicio();

				if (lista.tamano() != 0) {
					System.out.println("Seleccione qué desea hacer:");
					System.out.println("1.-Cambiar el estado del Cliente");
					System.out.println("2.-Editar los datos ingresados del Cliente");
					int opcion = sc.nextInt();
					System.out.println("Ingrese RUN del Cliente a editar:");
					String run =sc.next();
					int index = editarCliente.buscarPorRun(run);
					System.out.println("Datos del cliente a editar:");
					
					if (opcion == 1) {
						System.out.println("----Actualizando ESTADO del Cliente-----");
						editarCliente.editarEstadoCliente(index);
					} else if (opcion == 2) {
						System.out.println("----Actualizando datos del Cliente-----");
						editarCliente.mostrarCliente(index);
						System.out.println("Ingrese el número del campo a editar");
						int valor = sc.nextInt();
						editarCliente.editarDatosCliente(index, valor);
						editarCliente.mostrarCliente(index);
						System.out.println("-------------------------------------");
						

					} else {
						System.out.println("valor ingresado incorrecto");
						sc.next();
					}
					
					break;
				} else {
					System.out.println("No existen registros a modificar");
				}
				break;

			case 4:
//				cargar datos
				IMenu archivoServicio = new ArchivoServicio();

				System.out.println(
						"Ingrese la ruta del archivo a importar. El nombre del archivo tiene que ser DBClientes.csv");
				String ruta = sc.next();
				archivoServicio.importarDatos(ruta);

				break;

			case 5:
//				exportar datos	
				
				IMenu exportador = new ArchivoServicio();
				exportador.exportarDatos();
	
				break;
			case 6:
				IMenu terminar = new Utilidad();
				terminar.terminarPrograma();
				
				break;

			default:				
				System.out.println("Opción no valida");
			}
		} catch (java.util.InputMismatchException ex) {
			System.out.println("El valor ingresado es incorrecto");
			sc.next();
		}
	}while(op!=6);

	sc.close();

}}
