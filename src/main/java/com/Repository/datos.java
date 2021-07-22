package com.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.domain.Empleado;
import com.domain.PuestoTrabajo;



@Component
public class datos {
	
	private List<Empleado> DATOS_EMPLEADOS = new ArrayList<>();
	
	public datos() {
		DATOS_EMPLEADOS.add(new Empleado("lola", "roig", PuestoTrabajo.DP));
		DATOS_EMPLEADOS.add(new Empleado("marta", "alma", PuestoTrabajo.DO));
		DATOS_EMPLEADOS.add(new Empleado("mireia", "lei", PuestoTrabajo.DG));
		DATOS_EMPLEADOS.add(new Empleado("ana", "casals", PuestoTrabajo.DN));
	
	}

	public List<Empleado> getDATOS_EMPLEADOS() {
		return DATOS_EMPLEADOS;
	}
	
}