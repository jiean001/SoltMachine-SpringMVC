package Aogu.Genes.Controller;

import Aogu.Genes.Domain.TGoodsinfoEntity;
import Aogu.Genes.Domain.TGoodskindinfoEntity;
import Aogu.Genes.Service.GoodsService;
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
 * 商品控制器
 */

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    private Log logger= LogFactory.getLog(GoodsController.class);
    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private KindService kindService;

    //获取商品列表信息，并查询获取订单数量和用户数量
    @RequestMapping("/listByPage")
    public String getList(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                             @RequestParam(value = "pageSize",required = false)Integer pageSize,
                             Model model)
    {
        try {
            logger.info("获取商品列表");
            Page<TGoodsinfoEntity> goodsEntitys=null;
            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }
            if (pageSize==null||pageSize.equals("")){
                pageSize=10;
            }
            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);;
            goodsEntitys=goodsService.findGoodsEntitysByPage(pageRequest);
            model.addAttribute("goodsentityspage",goodsEntitys);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/backpage/product/goodsList";
    }

    @RequestMapping("/addPage")
    //转到增添商品页面
    public String addPage(Model model)
    {
        List<TGoodskindinfoEntity> kindentitys= kindService.findAllIsvalid() ;
        model.addAttribute("kindentitys",kindentitys);
        logger.info("kindentitys size："+kindentitys.size());
        return "/backpage/product/goodsAdd";
    }
    //增添商品
    @ResponseBody
    @RequestMapping("/add")
    public Object addGoods(TGoodsinfoEntity goodsEntity,String goodskindid,HttpSession session)
    {
        try {
            logger.info("开始添加商品");
            if(goodskindid!=null&&goodskindid!=""){
                TGoodskindinfoEntity goodskind=kindService.findOneById(goodskindid);
                goodsEntity.setGoodskind(goodskind);
            }
            goodsEntity.setValid(0);
            goodsEntity.setOperator((String) session.getAttribute("admin"));
            goodsService.save(goodsEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @RequestMapping("/showPage")
    //转到查看修改商品页面
    public String showPage(@RequestParam(value="goodsid")String goodsid,
                          Model model)
    {
        TGoodsinfoEntity goodsEntity=goodsService.findOneById(goodsid);
        model.addAttribute("goodsentity",goodsEntity);
        return "/backpage/product/goodsShow";
    }

    @RequestMapping("/editPage")
    //转到查看修改商品页面
    public String editPage(@RequestParam(value="goodsid")String goodsid,
                          Model model)
    {
        TGoodsinfoEntity goodsEntity=goodsService.findOneById(goodsid);
        model.addAttribute("goodsEntity",goodsEntity);
        List<TGoodskindinfoEntity> kindentitys= kindService.findAllIsvalid() ;
        model.addAttribute("kindentitys",kindentitys);
        return "/backpage/product/goodsEdit";
    }

    //修改商品
    @ResponseBody
    @RequestMapping("/edit")
    public Object editGoods(TGoodsinfoEntity goodsEntity,String goodskindid,HttpSession session)
    {
        try {
            logger.info("开始修改商品");
            if(goodskindid!=null&&goodskindid!=""){
                TGoodskindinfoEntity goodskind=kindService.findOneById(goodskindid);
                goodsEntity.setGoodskind(goodskind);
            }
            goodsEntity.setOperator((String) session.getAttribute("admin"));
            goodsService.save(goodsEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }

    //删除商品
    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteGoods(@RequestParam(value="goodsid")String goodsid,HttpSession session)
    {
        try {
            logger.info("开始删除商品");
            TGoodsinfoEntity goodsEntity=goodsService.findOneById(goodsid);
            goodsEntity.setValid(1);
            goodsEntity.setOperator((String) session.getAttribute("admin"));
            goodsService.save(goodsEntity);
            return executeResult.jsonReturn(200);
        }catch (Exception e){
            e.printStackTrace();
            return  executeResult.jsonReturn(300,e.getMessage());
        }
    }
}


