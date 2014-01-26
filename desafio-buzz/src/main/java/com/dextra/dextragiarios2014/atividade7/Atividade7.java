package com.dextra.dextragiarios2014.atividade7;

public class Atividade7 {
	
	private Integer dia;
	private Integer mes;
	private Integer ano;
	
	public Boolean verificaData(Long dia, Long mes, Long ano) {
		if (this.mes > 12 || this.dia >31){
			return false;
		}
			
		if (this.mes <= 7 && this.mes%2 == 1 && this.dia <= 31) {
			return true;
		}
		else if (this.mes > 7 && this.mes%2 == 0 && this.dia <= 30) {
			if (this.mes == 2 && this.dia <= 29 && this.ano%4 == 0) {
				return true;
			} else if (this.mes == 2 && this.dia <= 29 && this.ano%4 != 0) {
				return false;
			} else {
				return true;
			}
		} 
		return false;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	

}
