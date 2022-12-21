/*

 */
package com.portfolio.argprograma.service;

import com.portfolio.argprograma.entity.Habilidades;
import java.util.List;


public interface ISHabilidades {
    public List<Habilidades> verHabilidad();
    public void crearHabilidad(Habilidades habil);
    public void borrarHabilidad(Long id);
    public Habilidades buscarHabilidad(Long id);
}
