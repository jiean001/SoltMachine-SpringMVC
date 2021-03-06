package Aogu.Genes.Controller;

import Aogu.Genes.Domain.TBusinessinfoEntity;
import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Domain.TUserinfoEntity;
import Aogu.Genes.Service.*;
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
/**
 * Created by gzw on 2017/8/15 0017.
 * 售货机控制器
 */

@Controller
@RequestMapping("/admin/machine")
public class MachineController {

    private Log logger= LogFactory.getLog(GoodsWayController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private MachineService machineService;
    @Autowired
    private TBusinessinfoService tBusinessinfoServices;
    @Autowired
    private TUserinfoService tUserinfoService;

    //获取机器列表信息
    @RequestMapping("/listByPage")
    public String getList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                          @RequestParam(value = "pageSize",required = false)Integer pageSize,
                          Model model, HttpSession session)
    {
        try {
            logger.info("获取售货机列表");
            Page<TMachineEntity> machinepage=null;
            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }
            if (pageSize==null||pageSize.equals("")){
                pageSize=10;
            }
            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);;
            String username = (String) session.getAttribute("admin");
            int userid = (tUserinfoService.findUserByusername(username)).getUserid();
            int businessid = (tBusinessinfoServices.findBusinessByUserID(userid)).getBusinessid();
            System.out.println(businessid+"###$$$######");
            machinepage=machineService.findMachineEntitysByPage(pageRequest,businessid);
            System.out.println(machinepage.getTotalElements()+"###");
            model.addAttribute("machinepage",machinepage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/machine/machineList";
    }

    @RequestMapping("/addPage")
    //转到增添机器页面
    public String addBusinessInfo(TMachineEntity tMachineEntity, Model model)
    {
        model.addAttribute("tMachineEntity",tMachineEntity);
        return "/backpage/machine/machineAdd";
    }

    //增添售货机
    @ResponseBody
    @RequestMapping("/add")
    public Object addMachine(TMachineEntity tMachineEntity,HttpSession session)
    {
        try {
            logger.info("开始添加售货机");
            String username = (String) session.getAttribute("admin");
            TUserinfoEntity user = tUserinfoService.findUserByusername(username);
            TBusinessinfoEntity business = tBusinessinfoServices.findBusinessByUserID(user.getUserid());
            TMachineEntity machine;
            try {
                machine = machineService.findMachineByNum(tMachineEntity.getMachinenum());
                System.out.println(machine.getMachinenum());
            }catch (Exception e){
                e.printStackTrace();
                return  executeResult.jsonReturn(300,e.getMessage());
            }
            machine.setMachinestate(0);
            machine.setMachineplace(tMachineEntity.getMachineplace());
            machine.setProducetime(tMachineEntity.getProducetime());
            machine.setBusinessid(business.getBusinessid());
            machineService.add(machine);

            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @RequestMapping("/editPage")
    //转到查看修改运营商信息页面
    public String editPage(@RequestParam(value="machineid")int machineid,
                          Model model)
    {
        TMachineEntity tMachineEntity=machineService.findMachineById(machineid);
        model.addAttribute("tMachineEntity",tMachineEntity);
        return "/backpage/machine/machineEdit";
    }

    //修改售货机信息
    @ResponseBody
    @RequestMapping("/edit")
    public Object editMachine(TMachineEntity tMachineEntity)
    {
        try {
            logger.info("开始修改售后机");
            TMachineEntity machine = machineService.findMachineById(tMachineEntity.getMachineid());
            machine.setMachineplace(tMachineEntity.getMachineplace());
            machineService.add(machine);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    //退役售后机
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteMachine(@RequestParam(value="machineid")int machineid)
    {
        try {
            logger.info("开始退役售货机");
            TMachineEntity machine=machineService.findMachineById(machineid);
            machine.setMachinestate(1);
            machineService.add(machine);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

}


