/*

 */
package com.portfolio.argprograma.service;


import com.portfolio.argprograma.entity.Banner;
import java.util.List;


public interface ISBanner {
    public List<Banner> verBanner();
    public void crearBanner(Banner bann);
    public void borrarBanner(Long id);
    public Banner buscarBanner(Long id);    
}
