package Aogu.Genes.Service;

import Aogu.Genes.Domain.TGoodsinfoEntity;
import Aogu.Genes.Repository.GoodsRepository;
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
import java.util.List;

/**
 * Created by michael on 2016/8/17 0017.
 */
@Transactional
@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public Page<TGoodsinfoEntity> findGoodsEntitysByPage(PageRequest pageRequest) {
        Specification<TGoodsinfoEntity> newsSpecification=new Specification<TGoodsinfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TGoodsinfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值
                predicate=criteriaBuilder.equal(root.get("valid"),"0");
                //添加
                predicateList.add(criteriaBuilder.and(predicate));

                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"goodsid");
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TGoodsinfoEntity> TGoodsinfoEntitys= null;
        try {
            TGoodsinfoEntitys=goodsRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TGoodsinfoEntitys.getTotalElements()>0?TGoodsinfoEntitys:null;
    }

    public List<TGoodsinfoEntity> findAllIsvalid() {
        return goodsRepository.findAllIsvalid();
    }

    public void save(TGoodsinfoEntity goodsEntity)
    {
        goodsRepository.save(goodsEntity);
    }

    public void delete(TGoodsinfoEntity goodsEntity)
    {
        goodsRepository.delete(goodsEntity);
    }

    public TGoodsinfoEntity findOneById(String goodsid){
        TGoodsinfoEntity goodsEntity = goodsRepository.findOneById(Integer.parseInt(goodsid));
        return goodsEntity;
    }

}
