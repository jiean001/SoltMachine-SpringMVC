package Aogu.Genes.Service;

import Aogu.Genes.Domain.TGoodskindinfoEntity;
import Aogu.Genes.Repository.KindRepository;
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
public class KindService {
    @Autowired
    private KindRepository kindRepository;

    public Page<TGoodskindinfoEntity> findKindEntitysByPage(PageRequest pageRequest) {
        Specification<TGoodskindinfoEntity> newsSpecification=new Specification<TGoodskindinfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TGoodskindinfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"goodskindid");
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TGoodskindinfoEntity> TGoodskindinfoEntitys= null;
        try {
            TGoodskindinfoEntitys=kindRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TGoodskindinfoEntitys.getTotalElements()>0?TGoodskindinfoEntitys:null;
    }

    public void save(TGoodskindinfoEntity kindEntity)
    {
        kindRepository.save(kindEntity);
    }

    public void delete(TGoodskindinfoEntity kindEntity)
    {
        kindRepository.delete(kindEntity);
    }

    public List<TGoodskindinfoEntity> findAllIsvalid(){
        List<TGoodskindinfoEntity> labs =kindRepository.findAllIsvalid();
        return labs;
    }

    public TGoodskindinfoEntity findOneById(String kindsid){
        TGoodskindinfoEntity kindEntity =kindRepository.findOneById(Integer.parseInt(kindsid));
        return kindEntity;
    }

}
