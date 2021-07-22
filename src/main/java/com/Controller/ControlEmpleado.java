package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.domain.*;
import com.Service.*;


@Controller
@RequestMapping("/")
public class ControlEmpleado {
	
	@Autowired
	Operaciones emplService;
	
	@RequestMapping
	public String getTodosEmpleados(Model model) {
		
		System.out.println("RequestMapping : 'getTodosEmpleados'");
		List<Empleado> listaEmpleados = emplService.getAllEmpleados();
		
		model.addAttribute("empleados", listaEmpleados);
		
		return "index";
	}

	@GetMapping("/{id}")
	public String buscarEmpleadoPorId(Model model, Integer id) {
		
		System.out.println("GetMapping: 'buscarEmpleadoPorId' " + id);
		model.addAttribute("empleados", emplService.getEmpleadoById(id));
		
		return "index";
	}
	
	@RequestMapping({"/editar", "/editar/{id}"})
	public String editarEmpleadoPorId(Model model, @PathVariable("id") Optional<Integer> id) {
		
		System.out.println("RequestMapping: 'editarEmpleadoPorId");
		
		if(id.isPresent()) {
			Empleado empleado = emplService.getEmpleadoById(id.get());
			System.err.println("Modificando empleado" + empleado.toString());
			model.addAttribute("empleado", empleado);
		}else {
			model.addAttribute("empleado", new Empleado());
		}
		
		return "crear-editar-empl";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarEmpleadoPorId(Model model, @PathVariable("id") Integer id) {
		System.out.println("RequestMapping: 'eliminarEmpleadoPorId' " + id);
		
		emplService.deleteById(id);
		
		return "redirect:/";
	}
	
	@RequestMapping("/crear")
	public String crearEmpleado(Model model) {
		
		System.out.println("RequestMapping: 'crearEmpleado'");
		model.addAttribute("empleado", new Empleado());
		
		return "crear-editar-empl";
	}
	
	@RequestMapping(path = "/modificarEmpleado", method = RequestMethod.POST)
	public String modificarEmpleado(Empleado empleado) {
		
		System.out.println("RequestMapping: 'modificarEmpleado'");
		System.err.println(empleado.toString());
		emplService.update(empleado);
		
		return "redirect:/";
	}
}
