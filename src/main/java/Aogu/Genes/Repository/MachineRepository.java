package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by michael on 2016/8/17 0017.
 */
public interface MachineRepository extends JpaRepository<TMachineEntity,String>,JpaSpecificationExecutor<TMachineEntity> {
    @Query("select o from TMachineEntity o where o.machineid=:machineid ")
    TMachineEntity findOneById(@Param("machineid") int machineid);

    @Query("select o from TMachineEntity o where o.machinenum=:machinenum ")
    TMachineEntity findOneByNum(@Param("machinenum") String machinenum);
}


