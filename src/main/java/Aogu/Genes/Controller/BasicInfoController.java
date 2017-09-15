package Aogu.Genes.Controller;


import Aogu.Genes.Domain.TBusinessinfoEntity;
import Aogu.Genes.Domain.TUserinfoEntity;
import Aogu.Genes.Service.TBusinessinfoService;
import Aogu.Genes.Service.TBusinessmaninfoService;
import Aogu.Genes.Service.TUserinfoService;
import Aogu.Genes.utils.ExecuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/basicInfo")
public class BasicInfoController {

    private Log logger= LogFactory.getLog(BasicInfoController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private TBusinessinfoService tBusinessinfoServices;
    @Autowired
    private TBusinessmaninfoService tBusinessmaninfoService;
    @Autowired
    private TUserinfoService tUserinfoService;

    @RequestMapping("/basicPage")
    //转到查看修改运营商信息页面
    public String basicPage(HttpSession session,
                          Model model,String type)
    {
        String username = (String) session.getAttribute("admin");
        String role = (String) session.getAttribute("role");
        //非1表示非超级管理员
        if(role.indexOf("1")== -1){
            TUserinfoEntity userinfoEntity = tUserinfoService.findUserByusername(username);
            model.addAttribute("userinfoEntity",userinfoEntity);
            int userid = userinfoEntity.getUserid();
            TBusinessinfoEntity business=tBusinessinfoServices.findBusinessByUserID(userid);
            //TUserinfoEntity userinfo = tUserinfoService.findUserByID(business.getUserid());
            model.addAttribute("businessinfoEntity",business);
            if(type.equals("1")){
                return "backpage/sysmanage/basicinfoShow";
            }else{
                return "backpage/sysmanage/basicinfoEdit";
            }
        }
        else{
            model.addAttribute("msg","对不起，您暂无该权限！");
            return "backpage/fail";
        }
    }

    //修改运营商信息
    @RequestMapping("/edit")
    public String editBasicInfo(TBusinessinfoEntity business,TUserinfoEntity userinfo)
    {
        try {
            logger.info("开始修改运营商");
            System.out.println("@@@@@@"+business.getBusinessname()+"@@@@@@");
            tBusinessinfoServices.add(business);
            tUserinfoService.add(userinfo);
            return "backpage/sysmanage/basicinfoShow";
        }catch (Exception e){
            e.printStackTrace();
            return "backpage/fail";
        }
    }

}
