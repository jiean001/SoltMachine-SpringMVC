package Aogu.Genes.Controller;

import Aogu.Genes.Domain.TFaultinfoEntity;
import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Domain.TMachinetypeEntity;
import Aogu.Genes.Service.ErrorMachineService;
import Aogu.Genes.Service.MachineService;
import Aogu.Genes.Service.TBusinessinfoService;
import Aogu.Genes.Service.TUserinfoService;
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
 * 故障售货机控制器
 */

@Controller
@RequestMapping("/admin/errormachine")
public class ErrorMachineController {

    private Log logger= LogFactory.getLog(GoodsWayController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private MachineService machineService;
    @Autowired
    private TBusinessinfoService tBusinessinfoServices;
    @Autowired
    private TUserinfoService tUserinfoService;
    @Autowired
    private ErrorMachineService errormachineService;

    //获取故障机器列表信息
    @RequestMapping("/listByPage")
    public String getList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                          @RequestParam(value = "pageSize",required = false)Integer pageSize,
                          Model model, HttpSession session)
    {
        try {
            logger.info("获取售货机列表");
            Page<TFaultinfoEntity> errormachinepage=null;
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
            errormachinepage=errormachineService.findErrorMachineByPage(pageRequest,businessid);
            model.addAttribute("errormachinepage",errormachinepage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/machine/errormachineList";
    }


    @RequestMapping("/editPage")
    //转到维护故障售后机页面
    public String editPage(@RequestParam(value="faultid")int faultid,
                          Model model)
    {
        TFaultinfoEntity tFaultinfoEntity = errormachineService.findOneById(faultid);
        int machineid = tFaultinfoEntity.getMachine().getMachineid();
        TMachineEntity tMachineEntity=machineService.findMachineById(machineid);
        model.addAttribute("fault",tFaultinfoEntity);
        model.addAttribute("machine",tMachineEntity);
        return "/backpage/machine/errormachineEdit";
    }

    //维护故障售后机
    @ResponseBody
    @RequestMapping("/edit")
    public Object editErrorMachine(TFaultinfoEntity tFaultinfoEntity,TMachineEntity tMachineEntity)
    {
        try {
            logger.info("开始修改售后机");
            TMachineEntity machine = machineService.findMachineById(tMachineEntity.getMachineid());
            TFaultinfoEntity fault = errormachineService.findOneById(tFaultinfoEntity.getFaultid());
            fault.setRepairman(tFaultinfoEntity.getRepairman());
            machineService.add(machine);
            errormachineService.add(fault);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }



}


