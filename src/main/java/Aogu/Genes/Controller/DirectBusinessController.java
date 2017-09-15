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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/directBusiness")
public class DirectBusinessController {

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

    //获取运营商列表信息
    @RequestMapping("/listByPage")
    public String getBusinessList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                             @RequestParam(value = "pageSize",required = false)Integer pageSize,
                             HttpSession session, Model model)
    {
        try {
            logger.info("获取直属运营商列表");
            Page<TBusinessinfoEntity> businessinfoEntities=null;
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
            int fatherbusinessid = 0;
            if(bussinessinfo != null){
                fatherbusinessid = bussinessinfo.getBusinessid();
            }
            businessinfoEntities=tBusinessinfoServices.findDirectBusinessEntitysByPage(pageRequest,fatherbusinessid);
            model.addAttribute("businesssinfoentitiespage",businessinfoEntities);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/sysmanage/directbusinessList";
    }


    @RequestMapping("/addPage")
    //转到增添运营商页面
    public String addBusinessInfo(TBusinessinfoEntity businessinfoEntity, TUserinfoEntity tUserinfoEntity, Model model)
    {
//        System.out.println(businessinfoEntity.getBusinessname()+"######@@@@@");
//        System.out.println(tUserinfoEntity.getUsername()+"######@@@@@");
//        System.out.println(model.toString()+"#####@@@@@");
        model.addAttribute("businessinfoEntity",businessinfoEntity);
        model.addAttribute("tUserinfoEntity",tUserinfoEntity);

//        System.out.println(model.toString()+"#####@@@@@");
        return "/backpage/sysmanage/directbusinessAdd";
    }

    //增添运营商
    @ResponseBody
    @RequestMapping("/add")
    public Object addBusiness(TBusinessinfoEntity businessinfoEntity,TUserinfoEntity tUserinfoEntity,HttpSession session)
    {
        try {
            logger.info("开始添加直属运营商");
//            labEntity.setUsernumber(0);
//            labEntity.setOrdernumber(0);
            //添加账号
            tUserinfoEntity.setValid(0);
            tUserinfoService.add(tUserinfoEntity);
            String username = tUserinfoEntity.getUsername();
            TUserinfoEntity tUserinfoEntity1 = tUserinfoService.findUserByusername(username);
            //为运营商管理账号添加管理员角色
            TUserrolesEntity userrole = new TUserrolesEntity();
            userrole.setUserid(tUserinfoEntity1.getUserid());
            //2表示系统管理员
            userrole.setRoleid(2);
            tUserrolesService.add(userrole);
            businessinfoEntity.setUserid(tUserinfoEntity1.getUserid());
            String fatherbusinessusername = (String) session.getAttribute("admin");
            TUserinfoEntity fatheruser = tUserinfoService.findUserByusername(fatherbusinessusername);
            businessinfoEntity.setValid(0);
            //这里有bug，如果是添加的用户进行登录会怎么办？进而如果是不同的角色登录怎么控制
            String role = (String) session.getAttribute("role");
            //非1表示非超级管理员，即超级管理员添加的组织机构无父机构id
            if(role.indexOf("1")== -1){
                TBusinessinfoEntity fatherbusiness = tBusinessinfoServices.findBusinessByUserID(fatheruser.getUserid());
                businessinfoEntity.setFatherbusinessid(fatherbusiness.getBusinessid());
            }
            tBusinessinfoServices.add(businessinfoEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @RequestMapping("/editPage")
    //转到查看修改运营商信息页面
    public String editPage(@RequestParam(value="businessid")int businessid,
                          Model model)
    {
        System.out.println(businessid+"$$$$$$$$$");
        TBusinessinfoEntity business=tBusinessinfoServices.findBusinessById(businessid);
        TUserinfoEntity userinfo = tUserinfoService.findUserByID(business.getUserid());
        model.addAttribute("businessinfoEntity",business);
        model.addAttribute("userinfoEntity",userinfo);
        return "/backpage/sysmanage/directbusinessEdit";
    }

    //修改运营商信息
    @ResponseBody
    @RequestMapping("/edit")
    public Object editBusiness(TBusinessinfoEntity business,TUserinfoEntity userinfo)
    {
        try {
            logger.info("开始修改运营商");
            System.out.println("@@@@@@"+business.getBusinessname()+"@@@@@@");
            tBusinessinfoServices.add(business);
            tUserinfoService.add(userinfo);
            //为运营商管理账号添加管理员角色
            TUserrolesEntity userrole = new TUserrolesEntity();
            userrole.setUserid(userinfo.getUserid());
            //2表示系统管理员
            userrole.setRoleid(2);
            tUserrolesService.add(userrole);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    //删除运营商
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteBusness(@RequestParam(value="businessid")int businessid)
    {
        try {
            logger.info("开始删除直属运营商");
            TBusinessinfoEntity business=tBusinessinfoServices.findBusinessById(businessid);
            business.setValid(1);
            tBusinessinfoServices.add(business);
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
