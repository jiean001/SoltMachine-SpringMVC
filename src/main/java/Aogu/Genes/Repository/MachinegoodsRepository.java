package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TMachineEntity;
import Aogu.Genes.Domain.TMachinegoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by michael on 2016/8/17 0017.
 */
public interface MachinegoodsRepository extends JpaRepository<TMachinegoodsEntity,String>,JpaSpecificationExecutor<TMachinegoodsEntity> {

}


