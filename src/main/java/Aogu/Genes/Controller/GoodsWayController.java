package Aogu.Genes.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import Aogu.Genes.Domain.TGoodsinfoEntity;
import Aogu.Genes.Domain.TGoodswaygoodsEntity;
import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Domain.TMachinegoodsEntity;
import Aogu.Genes.Service.GoodsService;
import Aogu.Genes.Service.GoodsWayService;
import Aogu.Genes.Service.MachineService;
import Aogu.Genes.Service.TBusinessinfoService;
import Aogu.Genes.Service.TUserinfoService;
import Aogu.Genes.utils.ExecuteResult;

/**
 * Created by hx on 2016/8/17 0017.
 * 商品控制器
 */

@Controller
@RequestMapping("/admin/goodsway")
public class GoodsWayController {

	private Log logger= LogFactory.getLog(GoodsWayController.class);
	private ExecuteResult executeResult=new ExecuteResult();

	@Autowired
	private GoodsWayService goodswayService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private TUserinfoService tUserinfoService;
	@Autowired
	private TBusinessinfoService tBusinessinfoServices;
	@Autowired
	private MachineService machineService;

	//获取机器列表信息
	@RequestMapping("/listByPage")
	public String listByPage(@RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
			@RequestParam(value = "pageSize",required = false)Integer pageSize,String type,
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
			model.addAttribute("vementityspage",machinepage);
			model.addAttribute("type",type);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "/backpage/product/machineList";
	}

	@RequestMapping("/setGoodsWay")
	public String setGoodsWay(@RequestParam(value="machineid")String machineid,
			Model model)
	{
		TMachineEntity machineEntity=goodswayService.findMachineEntityById(machineid);
		model.addAttribute("machineEntity",machineEntity);
		List<TGoodswaygoodsEntity> goodswaygoodsEntitys = goodswayService.findAllByMachineid(machineid);
		model.addAttribute("goodswaygoodsEntitys",goodswaygoodsEntitys);
		return "/backpage/product/setGoodsWay";
	}

	@RequestMapping("/setGoodsWayGoods")
	public String setGoodsWayGoods(@RequestParam(value="machineid")String machineid,
			Model model)
	{
		TMachineEntity machineEntity=goodswayService.findMachineEntityById(machineid);
		model.addAttribute("machineEntity",machineEntity);
		List<TGoodswaygoodsEntity> goodswaygoodsEntitys = goodswayService.findAllByMachineid(machineid);
		model.addAttribute("goodswaygoodsEntitys",goodswaygoodsEntitys);
		return "/backpage/product/setGoodsWayGoods";
	}

	//删除货道商品关联
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteGoodswaygoods(@RequestParam(value="goodswaygoodsid")String goodswaygoodsid,HttpSession session)
	{
		try {
			logger.info("开始删除货道商品关联");
			TGoodswaygoodsEntity goodswaygoodsEntity=goodswayService.findOneById(goodswaygoodsid);
			goodswaygoodsEntity.setOperator((String) session.getAttribute("admin"));
			goodswayService.delete(goodswaygoodsEntity);
			return executeResult.jsonReturn(200);
		}catch (Exception e){
			e.printStackTrace();
			return  executeResult.jsonReturn(300,e.getMessage());
		}
	}

	@RequestMapping("/addGoodsWayPage")
	//转到增添页面
	public String addGoodsWayPage(@RequestParam(value="machineid")String machineid,Model model)
	{
		List<TGoodsinfoEntity> goodsinfoEntitys= goodsService.findAllIsvalid();
		List<Integer> goodswaynum = goodswayService.findGoodsWayNumById(machineid);
		model.addAttribute("goodsinfoEntitys",goodsinfoEntitys);
		model.addAttribute("goodswaynum",goodswaynum);
		model.addAttribute("machineid",machineid);
		return "/backpage/product/addGoodsWay";
	}

	@RequestMapping("/setFullGoodsWay")
	//一键补货
	public String setFullGoodsWay(@RequestParam(value="machineid")String machineid,Model model)
	{
		goodswayService.setFullGoodsWay(machineid);
		return "redirect:/admin/goodsway/listByPage?type="+2;
	}

	//增添货道商品关联
	@ResponseBody
	@RequestMapping("/addGoodsWay")
	public Object addGoodsWay(String machineid,String goodsid,String[] goodswaynum,TMachinegoodsEntity machinegoodsEntity,HttpSession session)
	{
		try {

			logger.info("开始添加货道商品关联");
			List<TGoodswaygoodsEntity> goodswaygoodsEntitys = new ArrayList<>();
			for(int i=0;i<goodswaynum.length;i++){
				TGoodswaygoodsEntity goodswaygoodsEntity = new TGoodswaygoodsEntity();
				if(goodsid!=null&&goodsid!=""){
					TGoodsinfoEntity goods =goodsService.findOneById(goodsid);
					goodswaygoodsEntity.setGoods(goods);
				}
				goodswaygoodsEntity.setGoodswaynum(Integer.parseInt(goodswaynum[i]));
				goodswaygoodsEntity.setMachineid(Integer.parseInt(machineid));
				goodswaygoodsEntity.setValid(0);
				goodswaygoodsEntity.setGoodsnum(0);
				goodswaygoodsEntity.setOperator((String) session.getAttribute("admin"));
				goodswaygoodsEntitys.add(goodswaygoodsEntity);
			}
			goodswayService.save(machinegoodsEntity,goodswaygoodsEntitys);
			return executeResult.jsonReturn(200);
		}catch (Exception e){
			e.printStackTrace();
			return  executeResult.jsonReturn(300,e.getMessage());
		}
	}

	@RequestMapping("/editPage")
	//转到查看修改商品页面
	public String editPage(@RequestParam(value="goodswaygoodsid")String goodswaygoodsid,
			Model model)
	{
		TGoodswaygoodsEntity goodswayEntity=goodswayService.findOneById(goodswaygoodsid);
		model.addAttribute("goodswayEntity",goodswayEntity);
		return "/backpage/product/goodswayEdit";
	}

	//修改
	@ResponseBody
	@RequestMapping("/edit")
	public Object editGoods(@RequestParam(value="goodsid")String goodsid,TGoodswaygoodsEntity goodswaygoodsEntity,HttpSession session)
	{
		try {
			logger.info("开始修改商品数量");
			if(goodsid!=null&&goodsid!=""){
				TGoodsinfoEntity goods =goodsService.findOneById(goodsid);
				goodswaygoodsEntity.setGoods(goods);
			}
			goodswaygoodsEntity.setOperator((String) session.getAttribute("admin"));
			goodswayService.save(goodswaygoodsEntity);
			return executeResult.jsonReturn(200);
		}catch (Exception e){
			e.printStackTrace();
			return  executeResult.jsonReturn(300,e.getMessage());
		}
	}
}


