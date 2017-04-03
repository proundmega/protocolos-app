package org.proundmega.protocolos.app.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.proundmega.protocolos.app.domain.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method = GET)
    public String aLogin() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = GET)
    public String vista(@RequestParam Optional<String> error, Model model, Authentication authentication) {
        model.addAttribute("usuario", new Usuario());

        if (error.isPresent()) {
            model.addAttribute("error", error.get());
        }
        if (authentication != null) {
            return "redirect:/usuario/" + ((User) authentication.getPrincipal()).getUsername();
        }
        return "login";
    }

    @RequestMapping(value = "/logout", method = GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
