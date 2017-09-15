package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TFaultinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ErrorMachineRepository extends JpaRepository<TFaultinfoEntity,String>,JpaSpecificationExecutor<TFaultinfoEntity> {
    @Query("select o from TFaultinfoEntity o where o.faultid=:faultid ")
    TFaultinfoEntity findOneById(@Param("faultid") int faultid);
}
