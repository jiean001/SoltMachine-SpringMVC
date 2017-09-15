package Aogu.Genes.Repository;

import Aogu.Genes.Domain.SaleStaticEntity;
import Aogu.Genes.Domain.TSalesrecordEntity;
import Aogu.Genes.Domain.TUserinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSalesRecordRepository extends JpaRepository<TSalesrecordEntity,Integer>,JpaSpecificationExecutor<TSalesrecordEntity> {

    @Query("select month(saletime) as month,count(*) as salesnum from TSalesrecordEntity t_salesrecord where t_salesrecord.machineid = :machineid and QUARTER(t_salesrecord.saletime) = QUARTER(:now) group by month(t_salesrecord.saletime)")
    public List<SaleStaticEntity> findSaleStaticEntity(@Param("machineid") int machineid, @Param("now") String now);

    @Query("select machineid,count(machineid) as salesnum from TSalesrecordEntity t_salesrecord where YEARWEEK(t_salesrecord.saletime) = YEARWEEK(:now) group by machineid order by salesnum desc")
    public List<SaleStaticEntity> findMachineByWeek(@Param("now") String now);

    @Query("select machineid,count(machineid) as salesnum from TSalesrecordEntity t_salesrecord where MONTH(t_salesrecord.saletime) = MONTH(:now) group by machineid order by salesnum desc")
    public List<SaleStaticEntity> findMachineByMonth(@Param("now") String now);

    @Query("select machineid,count(machineid) as salesnum from TSalesrecordEntity t_salesrecord where QUARTER(t_salesrecord.saletime) = QUARTER(:now) group by machineid order by salesnum desc")
    public List<SaleStaticEntity> findMachineByQuarter(@Param("now") String now);

    @Query("select machineid,count(machineid) as salesnum from TSalesrecordEntity t_salesrecord where YEAR(t_salesrecord.saletime) = YEAR(:now) group by machineid order by salesnum desc")
    public List<SaleStaticEntity> findMachineByYear(@Param("now") String now);

}
