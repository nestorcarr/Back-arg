/*

 */
package com.portfolio.argprograma.service;

import com.portfolio.argprograma.entity.Proyecto;
import java.util.List;


public interface ISProyecto {
    public List<Proyecto> verProyecto();
    public void crearProyecto(Proyecto proye);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
}
