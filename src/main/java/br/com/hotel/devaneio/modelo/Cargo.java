package br.com.hotel.devaneio.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcargos;
	private String cargo;
	
	
	public Cargo () {}

	public Cargo(Integer idcargos, String cargo) {
		this.idcargos = idcargos;
		this.cargo = cargo;
	}

	public Cargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getIdcargos() {
		return idcargos;
	}

	public void setIdcargos(Integer idcargos) {
		this.idcargos = idcargos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "ID Cargo: " + idcargos + "\n " + cargo;
	}


}
