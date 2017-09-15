package Aogu.Genes.Controller;

import Aogu.Genes.Domain.*;
import Aogu.Genes.Service.TBusinessinfoService;
import Aogu.Genes.Service.TBusinessmaninfoService;
import Aogu.Genes.Service.TUserinfoService;
import Aogu.Genes.Service.TUserrolesService;
import Aogu.Genes.utils.ExecuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/admin/directPerson")
public class DirectBusinessManController {

    private Log logger= LogFactory.getLog(DirectBusinessController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private TBusinessinfoService tBusinessinfoServices;
    @Autowired
    private TBusinessmaninfoService tBusinessmaninfoService;
    @Autowired
    private TUserinfoService tUserinfoService;
    @Autowired
    private TUserrolesService tUserrolesService;


    //获取人员列表信息
    @RequestMapping("/listByPage")
    public String getPersonList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                             @RequestParam(value = "pageSize",required = false)Integer pageSize,
                             HttpSession session, Model model)
    {
        try {
            logger.info("获取直属人员列表");
            Page<TBusinessmaninfoEntity> tBusinessmaninfoEntities=null;
            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }
            if (pageSize==null||pageSize.equals("")){
                pageSize=10;
            }
            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);
            String username = (String) session.getAttribute("admin");
            int userid = (tUserinfoService.findUserByusername(username)).getUserid();
            TBusinessinfoEntity bussinessinfo = tBusinessinfoServices.findBusinessByUserID(userid);
            int businessid = 0;
            if(!bussinessinfo.equals(null)){
                businessid = bussinessinfo.getBusinessid();
            }
            tBusinessmaninfoEntities=tBusinessmaninfoService.findDirectBusinessManEntitysByPage(pageRequest,businessid);
            model.addAttribute("personpage",tBusinessmaninfoEntities);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/sysmanage/directpersonList";
    }


    @RequestMapping("/addPage")
    //转到增添人员页面
    public String addPersonInfo(TBusinessmaninfoEntity tBusinessmaninfoEntities, TUserinfoEntity tUserinfoEntity, TRolesEntity tRolesEntity, Model model)
    {
        model.addAttribute("tBusinessmaninfoEntities",tBusinessmaninfoEntities);
        model.addAttribute("tUserinfoEntity",tUserinfoEntity);
        model.addAttribute("tRolesEntity",tRolesEntity);
        return "/backpage/sysmanage/directpersonAdd";
    }

    //增添人员
    @ResponseBody
    @RequestMapping("/add")
    public Object addPerson(TBusinessmaninfoEntity tBusinessmaninfoEntities, TUserinfoEntity tUserinfoEntity, TRolesEntity tRolesEntity, HttpSession session)
    {
        try {
            logger.info("开始添加直属人员");
//
//            System.out.println(tRolesEntity.getRoleid()+"####@@@@");
//            System.out.println("####@@@@");
            tUserinfoEntity.setValid(0);
            tUserinfoService.add(tUserinfoEntity);

            String username = tUserinfoEntity.getUsername();
            TUserinfoEntity tUserinfoEntity1 = tUserinfoService.findUserByusername(username);
            tBusinessmaninfoEntities.setUser(tUserinfoEntity1);
            int userid = tUserinfoEntity1.getUserid();
            int roleid = tRolesEntity.getRoleid();

            TUserrolesEntity tUserrolesEntity = new TUserrolesEntity();
            tUserrolesEntity.setRoleid(roleid);
            tUserrolesEntity.setUserid(userid);
            tUserrolesService.add(tUserrolesEntity);



            String businessusername = (String) session.getAttribute("admin");
            TUserinfoEntity businessuser = tUserinfoService.findUserByusername(businessusername);
            TBusinessinfoEntity business = tBusinessinfoServices.findBusinessByUserID(businessuser.getUserid());
            tBusinessmaninfoEntities.setBusinessid(business.getBusinessid());
            tBusinessmaninfoEntities.setJobstate(0);
//            tBusinessmaninfoEntities.setJobtime(new Date(System.currentTimeMillis()));
            tBusinessmaninfoService.add(tBusinessmaninfoEntities);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @RequestMapping("/editPage")
    //转到查看修改人员信息页面
    public String editPage(@RequestParam(value="businessmanid")int businessmanid,
                          Model model)
    {
        System.out.println("@@@@@@@@@");
        TBusinessmaninfoEntity businessman=tBusinessmaninfoService.findBusinessManByID(businessmanid);
        System.out.println(businessman.getBusinessmanid()+"######");
        TUserinfoEntity userinfo = businessman.getUser();
        TUserrolesEntity userrole = tUserrolesService.findUserRoleByUserID(userinfo.getUserid());
        model.addAttribute("tBusinessmaninfoEntity",businessman);
        model.addAttribute("userinfoEntity",userinfo);
        model.addAttribute("tUserrolesEntity",userrole);

        return "/backpage/sysmanage/directpersonEdit";
    }

    //修改人员信息
    @ResponseBody
    @RequestMapping("/edit")
    public Object editPerson(TBusinessmaninfoEntity businessman,TUserinfoEntity userinfo,TUserrolesEntity userrole)
    {
        try {
            logger.info("开始修改直属人员信息");
            System.out.println("@@@@@@"+businessman.getRealname()+"@@@@@@");

            tUserinfoService.add(userinfo);
            tUserrolesService.add(userrole);
            businessman.setUser(userinfo);
            tBusinessmaninfoService.add(businessman);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    //删除实验室
    @ResponseBody
    @RequestMapping("/delete")
    public Object deletePerson(@RequestParam(value="businessmanid")int businessmanid)
    {
        try {
            logger.info("开始删除直属人员");


            TBusinessmaninfoEntity businessman=tBusinessmaninfoService.findBusinessManByID(businessmanid);
            businessman.setJobstate(1);
            java.sql.Date time = new java.sql.Date(System.currentTimeMillis());
            businessman.setLeavetime(time);
            TUserinfoEntity user = businessman.getUser();
            user.setValid(1);
            tUserinfoService.add(user);
            tBusinessmaninfoService.add(businessman);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/checkAccount")
    public Object checkAccount( String businessname){
        TBusinessinfoEntity business= tBusinessinfoServices.findOneByBusinessname(businessname);
        Map<String,String> message=new HashMap<String,String>();
        Map<String,Object> jsonObj=new HashMap<String,Object>();
        if(business == null){
            jsonObj.put("ok","");
            return jsonObj;
        }else {
            message.put("error","运营商名称已存在！");
            jsonObj.put("data",message);
            return jsonObj;
        }
    }

    @ResponseBody
    @RequestMapping("/checkAccount1")
    public Object checkAccount( String businessname,int businessid){
        TBusinessinfoEntity business=tBusinessinfoServices.findBusinessById(businessid);
        if(business.getBusinessname().equals(businessname)){
            Map<String,String> jsonObj=new HashMap<String,String>();
            jsonObj.put("ok","");
            return jsonObj;
        }else {
            return checkAccount(businessname);
        }
    }
}
