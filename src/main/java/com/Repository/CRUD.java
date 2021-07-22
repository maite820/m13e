package com.Repository;

import java.util.List;

import com.domain.*;

public interface CRUD {
	public void insert(Empleado empleado);
	public void deleteById(Integer id);
	public void update(Empleado empleado);
	public Empleado getEmpleadoById(Integer id);
	public List<Empleado> getAllEmpleados();
}
