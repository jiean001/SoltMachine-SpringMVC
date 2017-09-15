package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TGoodsinfoEntity;
import Aogu.Genes.Domain.TGoodswaygoodsEntity;
import Aogu.Genes.Domain.TGoodswayinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by michael on 2016/8/17 0017.
 */
public interface GoodsWayRepository extends JpaRepository<TGoodswayinfoEntity,String>,JpaSpecificationExecutor<TGoodswayinfoEntity> {

}


