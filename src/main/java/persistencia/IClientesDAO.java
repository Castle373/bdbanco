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
  public Cliente InicioSesionCliente(Cliente cliente);
  public Cliente buscarPorIdCliente(String Cliente);
    public String buscarid(String usuario,String apellido,String colonia);
  public Cliente guardar(Cliente cliente);
  public Cliente editar(Cliente cliente);
  public Cliente eliminar(Cliente cliente);
}
