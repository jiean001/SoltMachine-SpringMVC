package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TBusinessmaninfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TBusinessmaninfoRepository extends JpaRepository<TBusinessmaninfoEntity,Integer>,JpaSpecificationExecutor<TBusinessmaninfoEntity> {
//    通过userid在用户信息表中找到对应的用户
    @Query("select businessman from TBusinessmaninfoEntity businessman where businessman.businessmanid = :businessmanid ")
    public TBusinessmaninfoEntity findBusinessManByID(@Param("businessmanid") int businessmanid);

    @Query("select businessuser from TBusinessmaninfoEntity businessuser where businessuser.businessid=?1 and businessuser.realname=?2 ")
    TBusinessmaninfoEntity findBusinessUser(int businessid,String realname);
}
