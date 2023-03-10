/*

 */
package com.portfolio.argprograma.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;




@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String institucion;
    private String proyecto;
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String profesion;
    @NotNull
    @Size(min = 1, max = 140, message = "no cumple con la longitud")
    private String logoproyecto;
    @NotNull
    @Lob
    private String tema;
    @NotNull
    @Lob
    private String temauno;
   
    private Date anio;
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String estado;

    public Proyecto() {
    }

    public Proyecto(String institucion, String proyecto, String profesion, String logoproyecto, String tema, String temauno, Date anio, String estado) {
        this.institucion = institucion;
        this.proyecto = proyecto;
        this.profesion = profesion;
        this.logoproyecto = logoproyecto;
        this.tema = tema;
        this.temauno = temauno;
        this.anio = anio;
        this.estado = estado;
    }

    
    
    
}
