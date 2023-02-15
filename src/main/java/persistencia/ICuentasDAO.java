/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Entidades.Cuenta;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ICuentasDAO {
  public List<Cuenta> ListaCuenta();
  public List<Cuenta> buscarPorIdCliente(String IdCliente);
  public List<Cuenta> buscarPorIdClienteActivas(String IdCliente);
  public Cuenta buscarPorNumeroCuenta(String Cuenta);
  public Cuenta guardar(Cuenta Cuenta);
  public Cuenta editarSaldo(Cuenta Cuenta);
  public Cuenta editarEstado(Cuenta Cuenta);
}
