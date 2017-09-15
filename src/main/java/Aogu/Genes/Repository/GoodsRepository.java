package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TGoodsinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by michael on 2016/8/17 0017.
 */
public interface GoodsRepository extends JpaRepository<TGoodsinfoEntity,String>,JpaSpecificationExecutor<TGoodsinfoEntity> {

    @Query("select o from TGoodsinfoEntity o where o.valid='0'")
    public List<TGoodsinfoEntity> findAllIsvalid();

    @Query("select o from TGoodsinfoEntity o where o.goodsid=:goodsid ")
    TGoodsinfoEntity findOneById(@Param("goodsid") int goodsid);

}


