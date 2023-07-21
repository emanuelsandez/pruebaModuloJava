package servicio;
import vista.*;
import modelo.*;

public class ClienteServicio implements IMenu{

	@Override
	public void listarCliente() {
		
		for (Cliente cliente : IMenu.listaClientes) {
			System.out.println(cliente.toString());
			System.out.println("------------------------");
		}			
	}

	
	public void agregarCliente() {
		Cliente cliente = new Cliente();

		System.out.println("--------CREAR CLIENTE-----------");
		System.out.println("Ingresa RUN del Cliente:");
		cliente.setRunCliente(sc.nextLine());
		System.out.println("Ingresa Nombre del Cliente:");
		cliente.setNombreCliente(sc.nextLine());
		System.out.println("Ingresa Apellido del Cliente:");
		cliente.setApellidoCliente(sc.nextLine());
		System.out.println("Ingresa años como Cliente:");
		cliente.setAniosCliente(sc.nextLine());
		cliente.setCategoriaCliente("Activo");

		listaClientes.add(cliente);
		System.out.println("Cliente agregado");

	}

	@Override
	public void editarDatosCliente(int index, int opcion) {
	
		Cliente cliente1 = new Cliente();
		cliente1 = listaClientes.get(index);
		
		switch(opcion) {
		
	case 1:
		System.out.println("1.-Ingrese nuevo RUN del Cliente:");
		String modifica1 = sc.next();
		cliente1.setRunCliente(modifica1);		
		listaClientes.set(index , cliente1);
		break;
		
	case 2:
		System.out.println("2.-Ingrese nuevo NOMBRE del Cliente:");
		String modifica2 = sc.nextLine();
		cliente1.setNombreCliente(modifica2);
		listaClientes.set(index, cliente1);
		break;
		
	case 3:
		System.out.println("3.-Ingrese nuevo APELLIDO del Cliente:");
		String modifica3 = sc.nextLine();
		cliente1.setApellidoCliente(modifica3);
		listaClientes.set(index, cliente1);
		break;
		
	case 4:
		System.out.println("4.-Ingrese nueva cantidad de años del Cliente:");
		String modifica4 = sc.nextLine();
		cliente1.setAniosCliente(modifica4);
		listaClientes.set(index, cliente1);
		break;
	
	default:
		System.out.println("Opción no valida");
	}
	}

	
	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int tamano() {
	
		return listaClientes.size();
	}


	@Override
	public void mostrarCliente(int index) {
		Cliente cliente2 = new Cliente();
		cliente2 = listaClientes.get(index);
		System.out.println("1.-El RUN del Cliente es: "+cliente2.getRunCliente());
		System.out.println("2.-El Nombre del Cliente es: "+cliente2.getNombreCliente());
		System.out.println("3.-El Apellido del Cliente es: "+cliente2.getApellidoCliente());
		System.out.println("4.-Los años como Cliente son: "+cliente2.getAniosCliente());
	}


	@Override
	public void editarEstadoCliente(int index) {
		Cliente cliente3 = new Cliente();
		cliente3 = listaClientes.get(index);
		System.out.println("Se estan editando los datos de "
		+cliente3.getNombreCliente()+" "+ cliente3.getApellidoCliente());
		System.out.println("El estado actual del cliente es: " +cliente3.getCategoriaCliente());
		System.out.println("1.-Si desea cambiar el estado del Cliente");
		System.out.println("2- Si desea mantener el estado del cliente");
		System.out.println("Ingrese una opción");
		int val = sc.nextInt();
		if(val==1) {
			if(cliente3.getCategoriaCliente().equals("Activo")) {
				cliente3.setCategoriaCliente("Inactivo");
				System.out.println("El estado del Cliente ha sido modificado a "+cliente3.getCategoriaCliente());
			}else {
				cliente3.setCategoriaCliente("Activo");
				System.out.println("El estado del Cliente ha sido modificado a "+cliente3.getCategoriaCliente());
			}
			
		}else if(val==2) {
			System.out.println("Se mantuvo el estado cliente como: "+cliente3.getCategoriaCliente()); 
			
		}else{
			System.out.println("Opción inválida");
		}
	}


	@Override
	public void importarDatos(String ruta) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int buscarPorRun(String run) {
		int index=0;
		for (Cliente cliente : listaClientes) {
			if(cliente.getRunCliente().equals(run)) {
				index=listaClientes.indexOf(cliente);
		}
		}
		return index;
	}

}
