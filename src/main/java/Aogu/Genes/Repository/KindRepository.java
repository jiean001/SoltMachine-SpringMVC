package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TGoodsinfoEntity;
import Aogu.Genes.Domain.TGoodskindinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by michael on 2016/8/17 0017.
 */
public interface KindRepository extends JpaRepository<TGoodskindinfoEntity,String>,JpaSpecificationExecutor<TGoodskindinfoEntity> {

    @Query("select o from TGoodskindinfoEntity o where o.valid='0'")
    public List<TGoodskindinfoEntity> findAllIsvalid();

    @Query("select o from TGoodskindinfoEntity o where o.goodskindid = :goodskindid ")
    TGoodskindinfoEntity findOneById(@Param("goodskindid") int goodskindid);
}


