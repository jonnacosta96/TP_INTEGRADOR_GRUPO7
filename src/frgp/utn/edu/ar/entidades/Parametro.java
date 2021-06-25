package frgp.utn.edu.ar.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parametros")
public class Parametro {
	
	@Id
	@Column(name="Id")
	private String id;
	@Column(name="StringParamValue")
	private String stringParamValue;
	@Column(name="IntParamValue")
	private Integer integerParamValue;
	
	public Parametro() {
		super();
	}

	public Parametro(String id, String stringParamValue, Integer integerParamValue) {
		super();
		this.id = id;
		this.stringParamValue = stringParamValue;
		this.integerParamValue = integerParamValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStringParamValue() {
		return stringParamValue;
	}

	public void setStringParamValue(String stringParamValue) {
		this.stringParamValue = stringParamValue;
	}

	public Integer getIntegerParamValue() {
		return integerParamValue;
	}

	public void setIntegerParamValue(Integer integerParamValue) {
		this.integerParamValue = integerParamValue;
	}
	
}
