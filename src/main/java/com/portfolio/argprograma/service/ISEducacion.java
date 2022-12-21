/*

 */
package com.portfolio.argprograma.service;

import com.portfolio.argprograma.entity.Educacion;
import java.util.List;


public interface ISEducacion {
    public List<Educacion> verEducacion();
    public void crearEducacion(Educacion educa);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);    
}
