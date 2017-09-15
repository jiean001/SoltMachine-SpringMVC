package Aogu.Genes.Service;


import Aogu.Genes.Domain.SaleStaticEntity;
import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Repository.GoodsRepository;
import Aogu.Genes.Repository.MachineRepository;
import Aogu.Genes.Repository.TSalesRecordRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class StaticService {
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private TSalesRecordRepository salesRecordRepository;
    @Autowired
    private GoodsRepository goodsRepository;

    private String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(date);
        return now;
    }

    public List<SaleStaticEntity> findSaleStaticEntityByMid(String machineid){
        return salesRecordRepository.findSaleStaticEntity(Integer.parseInt(machineid),getCurrentTime());
    }

    public List<TMachineEntity> findMachineByWeek(){
        List<SaleStaticEntity>  salesRecords = salesRecordRepository.findMachineByWeek(getCurrentTime());
        return gettMachineEntities(salesRecords);
    }

    private List<TMachineEntity> gettMachineEntities(List<SaleStaticEntity> salesRecords) {
        List<TMachineEntity> machinelist = new ArrayList<>();
        for (int i = 0; i < salesRecords.size(); i++) {
            System.out.print(salesRecords.get(i).getMachineid());
            TMachineEntity machine = machineRepository.findOneById(salesRecords.get(i).getMachineid());
            machine.setFreefield(String.valueOf(salesRecords.get(i).getSalesnum()));
            machinelist.add(machine);
        }
        return machinelist;
    }

    public List<TMachineEntity> findMachineByMonth(){
        List<SaleStaticEntity>  salesRecords = salesRecordRepository.findMachineByMonth(getCurrentTime());
        return gettMachineEntities(salesRecords);
    }

    public List<TMachineEntity> findMachineByQuarter(){
        List<SaleStaticEntity>  salesRecords = salesRecordRepository.findMachineByQuarter(getCurrentTime());
        return gettMachineEntities(salesRecords);
    }

    public List<TMachineEntity> findMachineByYear(){
        List<SaleStaticEntity>  salesRecords = salesRecordRepository.findMachineByYear(getCurrentTime());
        return gettMachineEntities(salesRecords);
    }

}
