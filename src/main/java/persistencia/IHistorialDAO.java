/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import ClasesUtilidad.Historial;
import java.util.List;

/**
 *
 * @author diego
 */
public interface IHistorialDAO {
    public List<Historial> HistorialRetiroSinCuenta(int idCuenta);
    public List<Historial> HistorialTransacciones(int idCuenta);
}
