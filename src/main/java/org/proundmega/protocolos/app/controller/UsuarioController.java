package org.proundmega.protocolos.app.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @RequestMapping(value = "/{usuario}", method = GET)
    public String loginUsuario(@PathVariable String usuario, Authentication authentication, Model modelo) {
        if(authentication != null) {
            modelo.addAllAttributes(getParametrosAMostrar(usuario));
            return "usuario";
        }
        else {
            return "redirect:/login";
        }
        
    }
    
    private Map<String, String> getParametrosAMostrar(String usuario) {
        Map<String, String> mapa = new HashMap<>();
        try {
            
            mapa.put("usuario", usuario);
            mapa.put("tiempo", LocalTime.now().toString());
            mapa.put("hostname", InetAddress.getLocalHost().getHostName());
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }
}
