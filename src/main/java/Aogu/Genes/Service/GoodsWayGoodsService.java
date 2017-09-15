package Aogu.Genes.Service;

import Aogu.Genes.Domain.TGoodswaygoodsEntity;
import Aogu.Genes.Domain.TGoodswayinfoEntity;
import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Domain.TMachinegoodsEntity;
import Aogu.Genes.Repository.GoodsWayGoodsRepository;
import Aogu.Genes.Repository.GoodsWayRepository;
import Aogu.Genes.Repository.MachineRepository;
import Aogu.Genes.Repository.MachinegoodsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 2016/8/17 0017.
 */
@Transactional
@Service
public class GoodsWayGoodsService {
    @Autowired
    private GoodsWayRepository goodswayRepository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private GoodsWayGoodsRepository goodswaygoodsRepository;
    @Autowired
    private MachinegoodsRepository machinegoodsRepository;

    //耿振旺新加
    public Page<TGoodswaygoodsEntity> findGoodsWayEntitysByPage(PageRequest pageRequest,final int machineid) {
        Specification<TGoodswaygoodsEntity> newsSpecification=new Specification<TGoodswaygoodsEntity>() {
            @Override
            public Predicate toPredicate(Root<TGoodswaygoodsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值
                predicate=criteriaBuilder.equal(root.get("machineid"),machineid);
                //添加
                predicateList.add(criteriaBuilder.and(predicate));

                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"machineid");
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TGoodswaygoodsEntity> TGoodswaygoodsEntitys= null;
        try {
            TGoodswaygoodsEntitys=goodswaygoodsRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TGoodswaygoodsEntitys.getTotalElements()>0?TGoodswaygoodsEntitys:null;
    }

    public void save(TMachinegoodsEntity machinegoodsEntity, List<TGoodswaygoodsEntity> goodswaygoodsEntitys) {
        machinegoodsRepository.save(machinegoodsEntity);
        for (int i = 0; i < goodswaygoodsEntitys.size(); i++) {
            goodswaygoodsRepository.save(goodswaygoodsEntitys.get(i));
        }
    }

    public void save(TGoodswaygoodsEntity goodswaygoodsEntity) {
       goodswaygoodsRepository.save(goodswaygoodsEntity);
    }

    public void delete(TGoodswaygoodsEntity goodswaygoodsEntity) {
        goodswaygoodsRepository.delete(goodswaygoodsEntity);
    }

    public TGoodswaygoodsEntity findOneById(String goodswaygoodsid) {
        return goodswaygoodsRepository.findOneById(Integer.parseInt(goodswaygoodsid));
    }


    public TMachineEntity findMachineEntityById(String machineid) {
        return machineRepository.findOneById(Integer.parseInt(machineid));
    }

    public List<TGoodswaygoodsEntity> findAllByMachineid(String machineid) {
        return goodswaygoodsRepository.findAllByMachineid(Integer.parseInt(machineid));
    }

    public void setFullGoodsWay(String machineid){
        List<TGoodswayinfoEntity> goodswayinfoEntitys = machineRepository.findOneById(Integer.parseInt(machineid)).getMachinetype().getGoodswayinfo();
        List<TGoodswaygoodsEntity> goodswaygoodsEntitys = goodswaygoodsRepository.findAllByMachineid(Integer.parseInt(machineid));
        for(int i=0;i<goodswaygoodsEntitys.size();i++){
            int goodswaynum = goodswaygoodsEntitys.get(i).getGoodswaynum();
            for(int j=0;j<goodswayinfoEntitys.size();j++){
                if(goodswayinfoEntitys.get(j).getGoodswaynum() == goodswaynum){
                    goodswaygoodsEntitys.get(i).setGoodsnum(Integer.parseInt(goodswayinfoEntitys.get(j).getGoodswaysize()));
                    goodswaygoodsRepository.save(goodswaygoodsEntitys.get(i));
                    break;
                }
            }
        }
    }

    public List<Integer> findGoodsWayNumById(String machineid) {
        List<Integer> goodswaynum = new ArrayList<>();
        TMachineEntity machine = machineRepository.findOneById(Integer.parseInt(machineid));
        List<TGoodswayinfoEntity> goodswayinfo = machine.getMachinetype().getGoodswayinfo();
        List<TGoodswaygoodsEntity> goodswaygoodsEntity = goodswaygoodsRepository.findAllByMachineid(Integer.parseInt(machineid));
        boolean flag;
        for (int i = 0; i < goodswayinfo.size(); i++) {
            flag = true;
            for (int j = 0; j < goodswaygoodsEntity.size(); j++) {
                if (goodswayinfo.get(i).getGoodswaynum().equals(goodswaygoodsEntity.get(j).getGoodswaynum())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                goodswaynum.add(goodswayinfo.get(i).getGoodswaynum());
            }
        }
        return goodswaynum;
    }


}
