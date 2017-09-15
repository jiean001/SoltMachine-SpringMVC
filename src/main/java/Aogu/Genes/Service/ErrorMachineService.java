package Aogu.Genes.Service;

import Aogu.Genes.Domain.TFaultinfoEntity;
import Aogu.Genes.Repository.ErrorMachineRepository;
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
public class ErrorMachineService {
    @Autowired
    private ErrorMachineRepository errorMachineRepository;


    public Page<TFaultinfoEntity> findErrorMachineByPage(PageRequest pageRequest, final int businessid) {
        Specification<TFaultinfoEntity> newsSpecification=new Specification<TFaultinfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TFaultinfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();
                Predicate predicate=null;
                Predicate predicate1=null;
                //匹配属性和属性对应的值
                predicate=criteriaBuilder.isNull(root.get("solvetime"));
                predicate1=criteriaBuilder.equal(root.get("machine").get("businessid"),businessid);
                //添加
                predicateList.add(criteriaBuilder.and(predicate));
                predicateList.add(criteriaBuilder.and(predicate1));
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"faulttime");
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TFaultinfoEntity> TFaultinfoEntities= null;
        try {
            TFaultinfoEntities=errorMachineRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TFaultinfoEntities.getTotalElements()>0?TFaultinfoEntities:null;
    }

    public void add(TFaultinfoEntity faultinfoEntity)
    {
        errorMachineRepository.save(faultinfoEntity);
    }


    public TFaultinfoEntity findOneById(int id ){
        TFaultinfoEntity machine=errorMachineRepository.findOneById(id);
        return machine;
    }

}
