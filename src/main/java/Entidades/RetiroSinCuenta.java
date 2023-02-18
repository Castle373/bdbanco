/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author diego
 */
public class RetiroSinCuenta {
    private String folio;
    private String numeroCuenta;
    private String cantidad;
    private String estado;
    private int contraseña;
    private String fechaHora;
    private String fechaHoraRetirado;
    private String fechaHoraLimite;
    
    
    public RetiroSinCuenta(){
  
    }
    public RetiroSinCuenta(String numeroCuenta, String cantidad) {
        this.numeroCuenta = numeroCuenta;
        this.cantidad = cantidad;
    }

    public RetiroSinCuenta(String folio, int contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }
   
    public RetiroSinCuenta(String folio, String numeroCuenta, String cantidad, String estado, int contraseña, String fechaHora, String fechaHoraRetirado, String fechaHoraLimite) {
        this.folio = folio;
        this.numeroCuenta = numeroCuenta;
        this.cantidad = cantidad;
        this.estado = estado;
        this.contraseña = contraseña;
        this.fechaHora = fechaHora;
        this.fechaHoraRetirado = fechaHoraRetirado;
        this.fechaHoraLimite = fechaHoraLimite;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
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

    public String getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    public void setFechaHoraLimite(String fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }
    
    
    
    
}
