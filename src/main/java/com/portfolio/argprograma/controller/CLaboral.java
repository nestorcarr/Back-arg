/*

 */
package com.portfolio.argprograma.controller;

import com.portfolio.argprograma.entity.Laboral;
import com.portfolio.argprograma.service.SLaboral;
import java.sql.Date;
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
@RequestMapping("laboral")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CLaboral {
    @Autowired
    SLaboral trabaServ;

    @GetMapping ("/ver")
    @ResponseBody
    public List<Laboral> verTrabajos(){
        return trabaServ.verTrabajos();
    }

    @PostMapping ("/new")
    public String agregarTrabajo (@RequestBody Laboral traba){
        trabaServ.crearTrabajo(traba);
        return "El trabajo fue creado correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String eliminarTrabajo(@PathVariable Long id){
        trabaServ.borrarTrabajo(id);
        return "El trabajo fue borrado correctamente";
    }

    
    @PutMapping ("/editar/{id}")
    public Laboral editTrabajo (@PathVariable Long id,
                                @RequestParam ("empresa") String nuevaEmpresa,
                                @RequestParam ("logo") String nuevoLogo,
                                @RequestParam ("cargo") String nuevoCargo,
                                @RequestParam ("inicio") Date nuevoInicio,
                                @RequestParam ("finalizado") Date nuevoFinalizado,
                                @RequestParam ("tareas") String nuevaTareas
    ){
        //Busca 
        Laboral traba=trabaServ.buscarTrabajo(id);
        
        traba.setEmpresa(nuevaEmpresa);
        traba.setLogo(nuevoLogo);
        traba.setCargo(nuevoCargo);
        traba.setInicio(nuevoInicio);
        traba.setFinalizado(nuevoFinalizado);
        traba.setTareas(nuevaTareas);
        
        trabaServ.crearTrabajo(traba);
        
        return traba;

    }
    
}
