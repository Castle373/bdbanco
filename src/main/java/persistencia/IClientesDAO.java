/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IClientesDAO {
  public List<Cliente> ListaCliente();
  public List<Cliente> ListaClienteNombre();
  public Cliente buscarPorIdCliente(int Cliente);
  public Cliente guardar(Cliente empleado);
  public Cliente editar(Cliente empleado);
  public Cliente eliminar(Cliente empleado);
}
