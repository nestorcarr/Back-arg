/*

 */
package com.portfolio.argprograma.controller;

import com.portfolio.argprograma.entity.Habilidades;
import com.portfolio.argprograma.service.SHabilidades;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("habilidad")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CHabilidades {
    @Autowired
    SHabilidades habilServ;
    
      
    @GetMapping ("/ver")
    @ResponseBody
    public List<Habilidades> verHabilidad(){
        return habilServ.verHabilidad();
    }

    @PostMapping ("/new")
    public String agregarHabilidad (@RequestBody Habilidades habil){
        habilServ.crearHabilidad(habil);
        return "La habilidad fue creada correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String eliminarHabilidad(@PathVariable Long id){
        habilServ.borrarHabilidad(id);
        return "La habilidad fue borrada correctamente";
    }

    @PutMapping ("/editar/{id}")
    public Habilidades editHabilidad (@PathVariable Long id,
                                @RequestParam ("habilidad") String nuevaHabilidad,
                                @RequestParam ("porcentaje") int nuevoPorcentaje,
                                @RequestParam ("color") String nuevoColor){
        //Busca habilidad
        Habilidades habil = habilServ.buscarHabilidad(id);
        
        habil.setHabilidad(nuevaHabilidad);
        habil.setPorcentaje(nuevoPorcentaje);
        habil.setColor(nuevoColor);
            
        habilServ.crearHabilidad(habil);

        return habil;

    }
}
