package Aogu.Genes.Service;


import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Repository.MachineRepository;
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
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public Page<TMachineEntity> findMachineEntitysByPage(PageRequest pageRequest,final int businessid) {
        Specification<TMachineEntity> newsSpecification=new Specification<TMachineEntity>() {
            @Override
            public Predicate toPredicate(Root<TMachineEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();
                Predicate predicate=null;
                Predicate predicate1=null;
                //匹配属性和属性对应的值
                predicate=criteriaBuilder.equal(root.get("machinestate"),"0");
                predicate1=criteriaBuilder.equal(root.get("businessid"),businessid);
                //添加
                predicateList.add(criteriaBuilder.and(predicate));
                predicateList.add(criteriaBuilder.and(predicate1));
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort=new Sort(Sort.Direction.fromString("desc"),"machinenum");
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);
        Page<TMachineEntity> TMachineEntitys= null;
        try {
            TMachineEntitys=machineRepository.findAll(newsSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(TMachineEntitys.getTotalElements()+"&&&&&&&&");
        return TMachineEntitys.getTotalElements()>0?TMachineEntitys:null;
    }

    public void add(TMachineEntity machine)
    {
        machineRepository.save(machine);
    }


    public TMachineEntity findMachineById(int id ){
        TMachineEntity machine=machineRepository.findOneById(id);
        return machine;
    }

    public TMachineEntity findMachineByNum(String num ){
        TMachineEntity machine=machineRepository.findOneByNum(num);
        return machine;
    }

}
