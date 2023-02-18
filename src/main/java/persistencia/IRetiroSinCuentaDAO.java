/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Entidades.RetiroSinCuenta;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IRetiroSinCuentaDAO {
    public RetiroSinCuenta guardar(RetiroSinCuenta retiroSinCuenta);
    public RetiroSinCuenta PorFolioContra(RetiroSinCuenta retiroSinCuenta);
    public void ProcedimientoRetirar(RetiroSinCuenta retiroSinCuenta);
}
