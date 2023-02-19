/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Transferencia;

/**
 *
 * @author Gabriel
 */
public interface ITransferenciaDAO {
      public Transferencia guardar(Transferencia Transferencia);
public Transferencia Operacion(float a, float b,Transferencia Transferencia,String Cuentaenviar);
}
