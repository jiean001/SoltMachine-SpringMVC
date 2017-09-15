package Aogu.Genes.Controller;

import Aogu.Genes.Domain.*;
import Aogu.Genes.Repository.GoodsWayGoodsRepository;
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
import java.util.List;


/**
 * Created by gzw on 2017/8/15 0017.
 * 售货机控制器
 */

@Controller
@RequestMapping("/admin/query")
public class QueryController {

    private Log logger= LogFactory.getLog(GoodsWayController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private MachineService machineService;
    @Autowired
    private TBusinessinfoService tBusinessinfoServices;
    @Autowired
    private TUserinfoService tUserinfoService;
    @Autowired
    private GoodsWayGoodsService goodswaygoodsService;
    @Autowired
    private StaticService staticService;

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
                pageSize=5;
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
        return "/backpage/query/querymachineList";
    }



    @RequestMapping("/queryPage")
    //转到查看售货机信息页面
    public String editPage(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                           @RequestParam(value = "pageSize",required = false)Integer pageSize,
                           @RequestParam(value="machineid")int machineid,
                          Model model)
    {
        TMachineEntity tMachineEntity=machineService.findMachineById(machineid);
        model.addAttribute("tMachineEntity",tMachineEntity);
        try {
            logger.info("获取售货机信息");
            Page<TGoodswaygoodsEntity> goodswaygoodspage=null;
            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }
            if (pageSize==null||pageSize.equals("")){
                pageSize=5;
            }
            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);
            goodswaygoodspage=goodswaygoodsService.findGoodsWayEntitysByPage(pageRequest,machineid);
            model.addAttribute("goodswaygoodspage",goodswaygoodspage);
            //折线图统计信息
            List<SaleStaticEntity> SaleStaticEntitys = staticService.findSaleStaticEntityByMid(String.valueOf(machineid));
            model.addAttribute("SaleStaticEntitys",SaleStaticEntitys);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/query/querymachineInfo";
    }

    @RequestMapping("/salesStatic")
    //转到查看售货机信息页面
    public String salesStatic(String type,Model model)
    {
        try {
            List<TMachineEntity> machinelist;
            if(type.equals("1")){
                machinelist = staticService.findMachineByWeek();
            }else if(type.equals("2")){
                machinelist = staticService.findMachineByMonth();
            }else if(type.equals("3")){
                machinelist = staticService.findMachineByQuarter();
            }else{
                machinelist = staticService.findMachineByYear();
            }
            model.addAttribute("machinelist",machinelist);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/query/querySalesInfo";
    }

}


