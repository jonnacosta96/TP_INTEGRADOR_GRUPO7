package frgp.utn.edu.ar.dto;

public class CrearCuentaDto {
	
	private Integer clienteId;
	private String cuentaNombre;
	private String tipoCuenta;
	public CrearCuentaDto(Integer clienteId, String cuentaNombre, String tipoCuenta) {
		super();
		this.clienteId = clienteId;
		this.cuentaNombre = cuentaNombre;
		this.tipoCuenta = tipoCuenta;
	}
	public CrearCuentaDto() {
		super();
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	
	
}
