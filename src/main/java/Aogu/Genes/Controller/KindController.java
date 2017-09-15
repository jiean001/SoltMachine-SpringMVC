package Aogu.Genes.Controller;

import Aogu.Genes.Domain.TGoodskindinfoEntity;
import Aogu.Genes.Service.KindService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hx on 2016/8/17 0017.
 */

@Controller
@RequestMapping("/admin/kind")
public class KindController {

    private Log logger= LogFactory.getLog(KindController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private KindService kindService;

    //获取商品种类列表信息，并查询获取订单数量和用户数量
    @RequestMapping("/listByPage")
    public String getKindList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                             @RequestParam(value = "pageSize",required = false)Integer pageSize,
                             Model model)
    {
        try {
            logger.info("获取商品种类列表");
            Page<TGoodskindinfoEntity> kindEntitys=null;
            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }
            if (pageSize==null||pageSize.equals("")){
                pageSize=10;
            }
            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);;
            kindEntitys=kindService.findKindEntitysByPage(pageRequest);
            model.addAttribute("kindentityspage",kindEntitys);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/product/kindList";
    }

    @RequestMapping("/addPage")
    //转到增添商品种类页面
    public String addPage(Model model)
    {
        List<TGoodskindinfoEntity> kindentitys= kindService.findAllIsvalid() ;
        model.addAttribute("kindentitys",kindentitys);
        logger.info("kindentitys size："+kindentitys.size());
        return "/backpage/product/kindAdd";
    }

    //增添商品种类
    @ResponseBody
    @RequestMapping("/add")
    public Object addKind(TGoodskindinfoEntity kindEntity,String fathergoodskindid,HttpSession session)
    {
        try {
            logger.info("开始添加商品种类");
            if(fathergoodskindid!=null&&fathergoodskindid!=""){
                TGoodskindinfoEntity fathergoodskind=kindService.findOneById(fathergoodskindid);
                kindEntity.setFathergoodskind(fathergoodskind);
            }
            kindEntity.setValid(0);
            kindEntity.setOperator((String) session.getAttribute("admin"));
            kindService.save(kindEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    //删除商品种类
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteKind(@RequestParam(value="kindid")String kindid,HttpSession session)
    {
        try {
            logger.info("开始删除商品种类");
            TGoodskindinfoEntity kindEntity=kindService.findOneById(kindid);
            kindEntity.setValid(1);
            kindEntity.setOperator((String) session.getAttribute("admin"));
            kindService.save(kindEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }
}


