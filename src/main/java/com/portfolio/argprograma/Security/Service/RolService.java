/*

 */
package com.portfolio.argprograma.Security.Service;

import com.portfolio.argprograma.Security.Entity.Rol;
import com.portfolio.argprograma.Security.Enums.RolNombre;
import com.portfolio.argprograma.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Es para mantener la persistencia, posi se cae el sistema
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
     irolRepository.save(rol);
    }    
    
}
