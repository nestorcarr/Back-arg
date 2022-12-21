/*

 */
package com.portfolio.argprograma.controller;

import com.portfolio.argprograma.entity.Educacion;
import com.portfolio.argprograma.service.SEducacion;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CEducacion {
    @Autowired
    SEducacion educaServ;

    @GetMapping ("/ver")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return educaServ.verEducacion();
    }

    @PostMapping ("/new")
    public String agregarEducacion (@RequestBody Educacion educa){
        educaServ.crearEducacion(educa);
        return "La educacion fue creada correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String eliminarEducacion(@PathVariable Long id){
        educaServ.borrarEducacion(id);
        return "La educacion fue borrada correctamente";
    }

    @PutMapping ("/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                @RequestParam ("universidad") String nuevaUniversidad,
                                @RequestParam ("logo") String nuevoLogo,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("institucion") String nuevaInstitucion,
                                @RequestParam ("estado") String nuevoEstado){
        //Busca educacion
        Educacion educa = educaServ.buscarEducacion(id);

        educa.setUniversidad(nuevaUniversidad);
        educa.setLogo(nuevoLogo);
        educa.setTitulo(nuevoTitulo);
        educa.setInstitucion(nuevaInstitucion);
        educa.setEstado(nuevoEstado);        
        
        educaServ.crearEducacion(educa);

        return educa;

    }
}
