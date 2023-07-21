package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {
	String clienteTexto="";
	 
	public void exportar(String path, List<Cliente> listaClientes) {
		
		File file = new File(path+"clientes.txt");
		listaClientes.forEach(c -> {
			clienteTexto += c.getRunCliente() + "," + c.getNombreCliente() + "," + c.getApellidoCliente() + "," + c.getAniosCliente()+ ","
		+c.getCategoriaCliente()+ "\n";
		});

		
		try {

			if (file.exists()) {
				System.out.println("El archivo ya fue creado, se sobreescribira");
			} else {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(clienteTexto);
				bw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
