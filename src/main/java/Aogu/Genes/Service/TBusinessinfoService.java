package Aogu.Genes.Service;

import Aogu.Genes.Domain.TBusinessinfoEntity;
import Aogu.Genes.Repository.TBusinessinfoRepository;
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
public class TBusinessinfoService {

    @Autowired
    private TBusinessinfoRepository tBusinessinfoRepository;

    public TBusinessinfoEntity findBusinessesByFatherID(int fatherid ){
        TBusinessinfoEntity businesses=tBusinessinfoRepository.findTBusinessesByFatherID(fatherid);
        return businesses;
    }

    public TBusinessinfoEntity findBusinessByUserID(int userid){
        TBusinessinfoEntity businesses = tBusinessinfoRepository.findBusinessByOrgUserID(userid);
        if(businesses == null){
            businesses = tBusinessinfoRepository.findBusinessByUserID(userid);
        }
        return businesses;
    }


    public TBusinessinfoEntity findOneByBusinessname(String businessname){
        TBusinessinfoEntity business=tBusinessinfoRepository.findBusinessByName(businessname);
        return business;
    }

    public void add(TBusinessinfoEntity businesses)
    {
        tBusinessinfoRepository.save(businesses);
    }

    public TBusinessinfoEntity findBusinessById(int businessid) {
        return tBusinessinfoRepository.findBusinessById(businessid);
    }

    public Page<TBusinessinfoEntity> findDirectBusinessEntitysByPage(PageRequest pageRequest,final int fatherbusinessid) {
        Specification<TBusinessinfoEntity> newsSpecification=new Specification<TBusinessinfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TBusinessinfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();
                //匹配属性和属性对应的值
                if(fatherbusinessid != 0){
                    Predicate predicate=criteriaBuilder.equal(root.get("fatherbusinessid"),fatherbusinessid);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                Predicate predicate1=criteriaBuilder.equal(root.get("valid"),0);
                predicateList.add(criteriaBuilder.and(predicate1));

                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"businessname");
        //起始，长度
        //Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TBusinessinfoEntity> TBusinessinfoEntity= null;
        try {
            TBusinessinfoEntity=tBusinessinfoRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TBusinessinfoEntity.getTotalElements()>0?TBusinessinfoEntity:null;
    }
}
