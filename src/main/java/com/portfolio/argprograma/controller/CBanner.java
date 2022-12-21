/*

 */
package com.portfolio.argprograma.controller;

import com.portfolio.argprograma.entity.Banner;
import com.portfolio.argprograma.service.SBanner;
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
@RequestMapping("banner")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CBanner {
    @Autowired
    SBanner bannServ;

    @GetMapping ("/ver")
    @ResponseBody
    public List<Banner> verBanner(){
        return bannServ.verBanner();
    }

    @PostMapping ("/new")
    public String agregarBanner (@RequestBody Banner bann){
        bannServ.crearBanner(bann);
        return "El banner fue creado correctamente";
    }

    @DeleteMapping ("/delete/{id}")
    public String eliminarBanner(@PathVariable Long id){
        bannServ.borrarBanner(id);
        return "El banner borrado correctamente";
    }

    @PutMapping ("/editar/{id}")
    public Banner editBanner (@PathVariable Long id,
                                @RequestParam ("carouselimag") String nuevoCarouselimag,
                                @RequestParam ("carouselimage") String nuevoCarouselimage,
                                @RequestParam ("carouselimagen") String nuevoCarouselimagen,
                                @RequestParam ("imageprincipal") String nuevaImageprincipal
                               ){
        //Busca banner
        Banner bann = bannServ.buscarBanner(id);

        bann.setCarouselimag(nuevoCarouselimag);
        bann.setCarouselimage(nuevoCarouselimage);
        bann.setCarouselimagen(nuevoCarouselimagen);
        bann.setImageprincipal(nuevaImageprincipal);
          
        
        bannServ.crearBanner(bann);

        return bann;
    }
    
}
