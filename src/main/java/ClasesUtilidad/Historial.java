/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesUtilidad;

/**
 *
 * @author diego
 */
public class Historial {
    private String numeroCuentaOrigen;
    private String numeroCuentaEnvio;
    private String folio;
    private String cantidad;
    private String estado;
    private String fechaHora;
    private String fechaHoraRetirado;

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public Historial(){
        
    }
    public String getNumeroCuentaEnvio() {
        return numeroCuentaEnvio;
    }

    public void setNumeroCuentaEnvio(String numeroCuentaEnvio) {
        this.numeroCuentaEnvio = numeroCuentaEnvio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFechaHoraRetirado() {
        return fechaHoraRetirado;
    }

    public void setFechaHoraRetirado(String fechaHoraRetirado) {
        this.fechaHoraRetirado = fechaHoraRetirado;
    }

    public Historial(String numeroCuentaEnvio, String folio, String cantidad, String estado, String fechaHora, String fechaHoraRetirado) {
        this.numeroCuentaEnvio = numeroCuentaEnvio;
        this.folio = folio;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.fechaHoraRetirado = fechaHoraRetirado;
    }
    
    
    
}
