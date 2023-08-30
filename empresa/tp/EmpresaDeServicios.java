package tp;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class EmpresaDeServicios {
	private String nombreEmpresa;
	private Map<Integer, Servicio> servicios;
	private Map<String, Double> facturacionPorServicio;
	private Map<String, Integer> serviciosRealizadosPorTipo;
	private Map<Integer, Especialista> especialistasRegistrados;
	private Map<Integer, Cliente> clientesRegistrados;
	private double facturacionTotal;




	public EmpresaDeServicios(String nombre) {
		nombreEmpresa = nombre;
		servicios = new HashMap<Integer, Servicio>();
		facturacionPorServicio = new HashMap<String, Double>();
		serviciosRealizadosPorTipo = new HashMap<String, Integer>();
		setearServiciosRealizadosPorTipo();
		especialistasRegistrados = new HashMap<Integer, Especialista>();
		clientesRegistrados = new HashMap<Integer, Cliente>();
		facturacionTotal = 0;
	}

	private void setearServiciosRealizadosPorTipo() {
		serviciosRealizadosPorTipo.put("Pintura", 0);
		serviciosRealizadosPorTipo.put("PinturaEnAltura", 0);
		serviciosRealizadosPorTipo.put("Electricidad", 0);
		serviciosRealizadosPorTipo.put("GasistaInstalacion", 0);
		serviciosRealizadosPorTipo.put("GasistaRevision", 0);

		
	}

	/*-------*/
	
	private boolean codigoServicioRegistrado(int codServicio) {
		return servicios.containsKey(codServicio);
	}

	public void registrarCliente(Integer dni, String nombre, String telefono)  {
		Cliente cliente = new Cliente(dni, nombre, telefono);
		if (clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni ya registrado en el sistema");
		}
		clientesRegistrados.put(dni, cliente);
	}

	/*-------*/
	public void registrarEspecialista(Integer numEspecialista, String nombre, String telefono, String especialidad){
		if(!serviciosRealizadosPorTipo.containsKey(especialidad))
			throw new RuntimeException ("Especialidad desconocida");
		Especialista especialista = new Especialista(numEspecialista, nombre, telefono, especialidad);
		if (especialistaRegistrado(numEspecialista)) {
			throw new RuntimeException("NumeroEspecialista ya registrado");
		}
		especialistasRegistrados.put(numEspecialista, especialista);
	}

	public boolean especialistaRegistrado(int numEspecialista) {
		return especialistasRegistrados.containsKey(numEspecialista);
	}

	private boolean especialidadEspecialista(int nroEspecialista, String especialidadDedicada) {
		Especialista nuevo = especialistasRegistrados.get(nroEspecialista);
		return nuevo.getEspecialidad().equals(especialidadDedicada);
	}

	/*-------*/
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {
		if (!clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni no registrado");
		}
		if (!especialistaRegistrado(nroEspecialista)) {
			throw new RuntimeException("NroEspecialista no registrado");
		}

		if (!especialidadEspecialista(nroEspecialista, "Electricidad")) {
			throw new RuntimeException("El especialista no realiza dicha tarea");
		}

		if ((precioPorHora <= 0) || (horasTrabajadas <= 0)) {
			throw new RuntimeException("PrecioPorHora o HoraTrabajada son menor a 0");
		}
		Servicio electricidad = new Electricidad(dni, nroEspecialista, direccion, precioPorHora, horasTrabajadas);
		this.servicios.put(electricidad.getCodServicio(), electricidad);
		this.especialistasRegistrados.get(nroEspecialista).agregarCodigoServicio(electricidad.getCodServicio());
		return electricidad.getCodServicio();
	}

	/*-------*/

	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado){
		if (!clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni no registrado");
		}
		if (!especialistaRegistrado(nroEspecialista)) {
			throw new RuntimeException("NroEspecialista no registrado");
		}
		if (!especialidadEspecialista(nroEspecialista, "Pintura")) {
			throw new RuntimeException("El especialista no realiza dicha tarea");
		}
		if ((precioPorMetroCuadrado <= 0) || (metrosCuadrados <= 0)) {
			throw new RuntimeException("PrecioPorMetroCuadrado o metrosCuadrados son menor a 0");
		}
		Servicio pintura = new Pintura(dni, nroEspecialista, direccion, metrosCuadrados, precioPorMetroCuadrado);
		this.servicios.put(pintura.getCodServicio(), pintura);
		this.especialistasRegistrados.get(nroEspecialista).agregarCodigoServicio(pintura.getCodServicio());
		return pintura.getCodServicio();
	}

	// altura
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios){
		if (!clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni no registrado");
		}
		if (!especialistaRegistrado(nroEspecialista)) {
			throw new RuntimeException("NroEspecialista no registrado");
		}
		if (!especialidadEspecialista(nroEspecialista, "PinturaEnAltura")) {
			throw new RuntimeException("El especialista no realiza dicha tarea");
		}
		if ((precioPorMetroCuadrado <= 0) || (metrosCuadrados <= 0) || (piso <= 0) || (seguro <= 0)
				|| (alqAndamios <= 0)) {
			throw new RuntimeException("Parametros <=0");
		}
		Servicio pinturaAltura = new PinturaAltura(dni, nroEspecialista, direccion, metrosCuadrados, precioPorMetroCuadrado, piso, seguro, alqAndamios);
		this.servicios.put(pinturaAltura.getCodServicio(), pinturaAltura);
		this.especialistasRegistrados.get(nroEspecialista).agregarCodigoServicio(pinturaAltura.getCodServicio());
		return pinturaAltura.getCodServicio();
	}

	/*-------*/
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto){
		if (!clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni no registrado");
		}
		if (!especialistaRegistrado(nroEspecialista)) {
			throw new RuntimeException("NroEspecialista no registrado");
		}
		if (!especialidadEspecialista(nroEspecialista, "GasistaInstalacion")) {
			throw new RuntimeException("El especialista no realiza dicha tarea");
		}
		if (precioPorArtefacto <= 0 || cantArtefactos <= 0) {
			throw new RuntimeException("Precio y cantidad de artefactos no pueden ser <=0 ");
		}

		Servicio gasistaInstalacion = new GasistaInstalacion(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
		this.servicios.put(gasistaInstalacion.getCodServicio(), gasistaInstalacion);
		this.especialistasRegistrados.get(nroEspecialista).agregarCodigoServicio(gasistaInstalacion.getCodServicio());
		return gasistaInstalacion.getCodServicio();
	}

	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto){
		if (!clientesRegistrados.containsKey(dni)) {
			throw new RuntimeException("Dni no registrado");
		}
		if (!especialistaRegistrado(nroEspecialista)) {
			throw new RuntimeException("NroEspecialista no registrado");
		}
		if (!especialidadEspecialista(nroEspecialista, "GasistaRevision")) {
			throw new RuntimeException("El especialista no realiza dicha tarea");
		}
		if (precioPorArtefacto <= 0 || cantArtefactos <= 0) {
			throw new RuntimeException("Precio y cantidad de artefactos no pueden ser <=0 ");
		}
		Servicio gasistaRevision = new GasistaRevision(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
		this.servicios.put(gasistaRevision.getCodServicio(), gasistaRevision);		
		this.especialistasRegistrados.get(nroEspecialista).agregarCodigoServicio(gasistaRevision.getCodServicio());
		return gasistaRevision.getCodServicio();

	}

	/*-------*/

	public double finalizarServicio(int codServicio, double costoMateriales) {
		if(!servicios.containsKey(codServicio))// O(1)
			throw new RuntimeException ("Codigo de servicio no existe");
		double costo = servicios.get(codServicio).finalizarServicio(costoMateriales); // 2 + O(1)
		String tipoServicio = servicios.get(codServicio).getClass().getSimpleName();// 2 + O(1)
		sumarCantidadDeServiciosRealizadosPorTipo(tipoServicio);// O(1)
		sumarfacturacionPorServicio(tipoServicio,costo);// O(1)
		int nroEspecialista = servicios.get(codServicio).getNroEspecialista();// 2 + O(1)
		especialistasRegistrados.get(nroEspecialista).actualizarHistorial(servicios.get(codServicio),codServicio);// O(1) + O (1) + O(1) 
		this.facturacionTotal += costo; // 2
		return costo;// 1
		//F(n) = O(1) + 2 + O(1) + 2 + O(1) + O(1) + O(1) + 2 + O(1) + O(1) + O (1) + O(1) + 2 + 1
		//F(n) = O(1) + 9 + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1)
		//F(n) =  O(1) + O(9) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1)
		//F(n) = O(1)
	}

	private void sumarCantidadDeServiciosRealizadosPorTipo(String tipoServicio) {
		if (!serviciosRealizadosPorTipo.containsKey(tipoServicio))			
			serviciosRealizadosPorTipo.put(tipoServicio, 1);			
		else
			serviciosRealizadosPorTipo.put(tipoServicio, serviciosRealizadosPorTipo.get(tipoServicio) + 1);
		
	}

	private void sumarfacturacionPorServicio(String tipoServicio, double costo) {
		if (!facturacionPorServicio.containsKey(tipoServicio))			
			facturacionPorServicio.put(tipoServicio, costo);			
		else
			facturacionPorServicio.put(tipoServicio, facturacionPorServicio.get(tipoServicio) + costo);
	}

	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		Map<String,Integer> nuevo = new HashMap<String,Integer>();
		nuevo.putAll(serviciosRealizadosPorTipo);
		return nuevo;// devolver un map distinto no generar aliasing
	}

	public double facturacionTotalPorTipo(String tipoServicio) {
		return facturacionPorServicio.get(tipoServicio);// O(1)
		//F(n) = O(1).
	}

	public double facturacionTotal() {
		return facturacionTotal;
	}

	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		if(!codigoServicioRegistrado(codServicio))// O(1)
			throw new RuntimeException ("El codigo de servicio no esta Registrado");
		String especialidad = servicios.get(codServicio).getClass().getSimpleName();// 2 + O(1)
		if(!especialidadEspecialista(nroEspecialista, especialidad))//O(1)
			throw new RuntimeException ("El especialista no realiza este oficio");
		servicios.get(codServicio).setNroEspecialista(nroEspecialista);// O(1)
		
		//F(n) = O(1) + 2 + O(1)+ O(1) + O(1).
		//F(n) = O(1) + O(1) + O(1) + O(1) + O(1).
		//F(n) = O(1).
	}


	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		return especialistasRegistrados.get(nroEspecialista).devolverHistorial();//O(1)
		// F (n) = O(1) ya que solo accedemos a traves de un HashMap.
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Servicios Solicitados: ");
		str.append("\n");
		str.append(servicios.values());
		str.append("\n\n");
		str.append("Especialistas Registrados: ");
		str.append("\n");
		str.append(especialistasRegistrados.values());
		str.append("\n\n");
		str.append("Clientes Registrados: ");
		str.append("\n");
		str.append(clientesRegistrados.values());
		str.append("\n\n");
		str.append("Servicios Realizados por Tipo: ");
		str.append("\n");
		str.append(serviciosRealizadosPorTipo);
		str.append("\n\n");
		str.append("Facturacion Por Servicio: ");
		str.append("\n");
		str.append(facturacionPorServicio);
		str.append("\n\n");
		str.append("Facturacion Total: ");
		str.append("\n");
		str.append(facturacionTotal);
		return str.toString();
	}

	

	

}
