package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TGoodskindinfoEntity;
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
public interface GoodsWayGoodsRepository extends JpaRepository<TGoodswaygoodsEntity,String>,JpaSpecificationExecutor<TGoodswaygoodsEntity> {
    @Query("select o from TGoodswaygoodsEntity o where o.machineid = :machineid order by o.goodswaynum asc")
    public List<TGoodswaygoodsEntity> findAllByMachineid(@Param("machineid") int machineid);

    @Query("select o from TGoodswaygoodsEntity o where o.goodswaygoodsid=:goodswaygoodsid ")
    TGoodswaygoodsEntity findOneById(@Param("goodswaygoodsid") int goodswaygoodsid);

}


