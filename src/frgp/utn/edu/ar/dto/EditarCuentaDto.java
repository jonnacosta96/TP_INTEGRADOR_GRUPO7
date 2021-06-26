package frgp.utn.edu.ar.dto;

public class EditarCuentaDto {
	
	private Integer nroCuenta;
	private String nombreCuenta;
	private String nombreCliente;
	private String tipoCuenta;
	
	
	public EditarCuentaDto() {
		super();
	}
	public EditarCuentaDto(Integer nroCuenta, String nombreCuenta) {
		super();
		this.nroCuenta = nroCuenta;
		this.nombreCuenta = nombreCuenta;
	}
	public Integer getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
}
