package com.domain;

public enum PuestoTrabajo {


		DP("pediatra", 35000),
		DO("oncologo", 46000),
		DG("ginecologo", 40000),
		DN("neurologo", 56700),
		
		ERR("Error",0);
		
		
		private String nombrePuesto;
		private double salario;
		
		PuestoTrabajo (String nombrePuesto, double salario){
			this.nombrePuesto = nombrePuesto;
			this.salario = salario;
		}

		public String getNombrePuesto() {
			return nombrePuesto;
		}

		public void setNombrePuesto(String nombrePuesto) {
			this.nombrePuesto = nombrePuesto;
		}

		public double getSalario() {
			return salario;
		}

		public void setSalario(double salario) {
			this.salario = salario;
		}

}

