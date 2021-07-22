package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.CRUD;
import com.Repository.datos;
import com.domain.*;


@Service
public class Operaciones implements CRUD {
	
	@Autowired
	datos datosEmpleados;

	@Override
	public void insert(Empleado empleado) {
		
		datosEmpleados.getDATOS_EMPLEADOS().add(empleado);
		System.out.println("Insertado empleado con ID: " + empleado.getId());
		
	}

	@Override
	public void deleteById(Integer id) {
		
		for(Empleado empleado: datosEmpleados.getDATOS_EMPLEADOS()) {
			if(empleado.getId() == id) {
				System.out.println("Eliminando empleado con ID: " + empleado.getId() + " ...");
				datosEmpleados.getDATOS_EMPLEADOS().remove(empleado);
				System.out.println("Empleado eliminado. ");
				break;
			}
		}
		
	}

	@Override
	public void update(Empleado empleado) {
		
		System.err.println(empleado.toString());

		for(Empleado empl: datosEmpleados.getDATOS_EMPLEADOS()) {
			if(empl.getId() == empleado.getId()) {
				System.out.println("ACTualizando empleado con ID: " + empl.getId());
				empl.setNombre(empleado.getNombre());
				empl.setApellido(empleado.getApellido());
				System.out.println(empleado.toString());
				empl.setPuesto(empleado.getPuesto());
				
				System.out.println(empl.toString());
				break;
			}
		}
		
	}

	@Override
	public Empleado getEmpleadoById(Integer id) {
		
		Empleado empleadoEncontrado = null;
		
		for(Empleado empleado: datosEmpleados.getDATOS_EMPLEADOS()) {
			if(empleado.getId() == id) {
				empleadoEncontrado = empleado;
				System.out.println("Encontrado empleado: " + empleadoEncontrado.toString());
				break;
			}
		}
		return empleadoEncontrado;
	}

	@Override
	public List<Empleado> getAllEmpleados() {

		return datosEmpleados.getDATOS_EMPLEADOS();
	}
	

	public boolean estaGuardado(Empleado empleado) {
		
		boolean guardado = false;
		
		for(Empleado emp: datosEmpleados.getDATOS_EMPLEADOS()) {
			
			guardado = emp.getId() == empleado.getId()? true : false;
		}
		
		String respuesta = guardado? "Empleado esta en la lista " : "Empleado NO esta en la lista";
		System.out.println(respuesta);
		return guardado;
	}
	
	public boolean isGuardado(Empleado empleado) {
		
		if(datosEmpleados.getDATOS_EMPLEADOS().contains(empleado)) {
			System.err.println("Esta en la lista");
			return true;
		}else {
			System.err.println("NO esta en la lista");
			return false;
		}
	}


}