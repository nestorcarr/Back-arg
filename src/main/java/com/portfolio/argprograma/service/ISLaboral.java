/*

 */
package com.portfolio.argprograma.service;

import com.portfolio.argprograma.entity.Laboral;
import java.util.List;


public interface ISLaboral {
    public List<Laboral> verTrabajos();
    public void crearTrabajo(Laboral per);
    public void borrarTrabajo(Long id);
    public Laboral buscarTrabajo(Long id);  
}
