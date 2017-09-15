package Aogu.Genes.Controller;

import Aogu.Genes.Domain.TRolesEntity;
import Aogu.Genes.Domain.TUserinfoEntity;
import Aogu.Genes.Service.TUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private TUserinfoService tUserinfoService;

    @RequestMapping("")
    public String toLogin() {
        return "backpage/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        HttpSession session, Model model) {
        String validateCode = (String) session.getAttribute("validateCode");
        TUserinfoEntity userinfoEntity = null;
        userinfoEntity = tUserinfoService.findUserByusername(username);
        if (userinfoEntity==null) {
            model.addAttribute("message", "该用户名不存在");
            return "backpage/login";
        } else if (!password.equals(userinfoEntity.getPassword())) {
            model.addAttribute("message", "用户名或密码错误");
            return "backpage/login";
        }  else if (!(userinfoEntity.getValid() == 0)) {
            model.addAttribute("message", "该用户不存在");
            return "backpage/login";
        } else {
            session.setAttribute("login", "success");
            session.setAttribute("admin",userinfoEntity.getUsername());
            //在登录时获取该用户的角色信息，并存入session
            Set<TRolesEntity> roleset = userinfoEntity.getRole();
            StringBuffer rolestr = new StringBuffer();
            for(TRolesEntity role : roleset){
                rolestr.append(role.getRoleid()+";");
            }
            System.out.println("-----------------------------------------"+rolestr.toString()+"----------------------------------------------");
            session.setAttribute("role",rolestr.toString());
            return "redirect:/admin/index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Enumeration em = session.getAttributeNames();
        while(em.hasMoreElements()){
            session.removeAttribute(em.nextElement().toString());
        }
        return "redirect:/admin/index";
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        try {
            String login = (String) session.getAttribute("login");
            if (login.equals("success")) {
                return "backpage/backIndex";
            } else {
                session.removeAttribute("login");
                return "backpage/login";
            }
        } catch (Exception e) {
            return "backpage/login";
        }
    }
}
