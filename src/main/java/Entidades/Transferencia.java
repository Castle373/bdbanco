/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Gabriel
 */

public class Transferencia {
        private String fechaHora;
    private String cantidad;
    private String numeroCuenta;
    private String numeroCuentaEnvio;
    
        public Transferencia(String fechaHora, String cantidad, String numeroCuenta, String numeroCuentaEnvio) {
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.numeroCuenta = numeroCuenta;
        this.numeroCuentaEnvio = numeroCuentaEnvio;
    }
        public  Transferencia (){
    
}

    public Transferencia(String cantidad, String numeroCuenta, String numeroCuentaEnvio) {
        this.cantidad = cantidad;
        this.numeroCuenta = numeroCuenta;
        this.numeroCuentaEnvio = numeroCuentaEnvio;
    }
    
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuentaEnvio() {
        return numeroCuentaEnvio;
    }

    public void setNumeroCuentaEnvio(String numeroCuentaEnvio) {
        this.numeroCuentaEnvio = numeroCuentaEnvio;
    }




    

    

}
