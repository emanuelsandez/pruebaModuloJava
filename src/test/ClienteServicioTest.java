package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import servicio.*;
import vista.IMenu;
import modelo.*;

class ClienteServicioTest {

	@Test
	public void agregarClienteTest() {
		ClienteServicio cliente = new ClienteServicio();
		cliente.agregarCliente();
		cliente.listarCliente();
		assertTrue(cliente.tamano() >= 0);

	}

	@Test
	public void agregarClienteNull() {

		Cliente cliente2 = new Cliente();
		IMenu.listaClientes.add(cliente2);
		System.out.println(cliente2.getRunCliente());
		String esperado = cliente2.getRunCliente();
		Assertions.assertNull(esperado);
	}

	@Test
	public void buscarPorRunTest() {
		// String runCliente, String nombreCliente, String apellidoCliente, String
		// aniosCliente, String categoriaCliente

		ClienteServicio app = new ClienteServicio();
		Cliente cli1 = new Cliente("1213", "Roberto", "Perez", "7", "Activo");
		Cliente cli2 = new Cliente("2525", "Joaquin", "Lopez", "8", "Inactivo");
		Cliente cli3 = new Cliente("3698", "Victoria", "Ramirez", "6", "Activo");
		IMenu.listaClientes.add(0, cli1);
		IMenu.listaClientes.add(1, cli2);
		IMenu.listaClientes.add(2, cli3);

		app.listarCliente();

		int respuesta = app.buscarPorRun("2525");
		assertEquals(1, respuesta);

	}

}
