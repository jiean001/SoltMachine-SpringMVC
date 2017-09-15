package Aogu.Genes.Service;


import Aogu.Genes.Domain.TBusinessmaninfoEntity;
import Aogu.Genes.Repository.TBusinessmaninfoRepository;
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

@Transactional
@Service
public class TBusinessmaninfoService {
    @Autowired
    private TBusinessmaninfoRepository tBusinessManInfoRepository;



    public void add(TBusinessmaninfoEntity userinfo)
    {
        tBusinessManInfoRepository.save(userinfo);
    }

    public TBusinessmaninfoEntity findBusinessUser(int businessid, String realname ){
        TBusinessmaninfoEntity userinfo=tBusinessManInfoRepository.findBusinessUser(businessid,realname);
        return userinfo;
    }

    public TBusinessmaninfoEntity findBusinessManByID(int businessmanid){
        TBusinessmaninfoEntity personinfo=tBusinessManInfoRepository.findBusinessManByID(businessmanid);
        return personinfo;
    }

    public Page<TBusinessmaninfoEntity> findDirectBusinessManEntitysByPage(PageRequest pageRequest, final int businessid) {
        Specification<TBusinessmaninfoEntity> newsSpecification=new Specification<TBusinessmaninfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TBusinessmaninfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值
                if(businessid != 0){
                    predicate=criteriaBuilder.equal(root.get("businessid"),businessid);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"realname");
        //起始，长度
        //Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TBusinessmaninfoEntity> tBusinessmaninfoEntities= null;
        try {
            tBusinessmaninfoEntities=tBusinessManInfoRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tBusinessmaninfoEntities.getTotalElements()>0?tBusinessmaninfoEntities:null;
    }
}

