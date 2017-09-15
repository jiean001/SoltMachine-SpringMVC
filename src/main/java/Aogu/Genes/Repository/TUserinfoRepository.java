package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TUserinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserinfoRepository extends JpaRepository<TUserinfoEntity,Integer>,JpaSpecificationExecutor<TUserinfoEntity> {
    @Query("select userinfo from TUserinfoEntity userinfo where userinfo.username = :username ")
    public TUserinfoEntity findUserByuserName(@Param("username") String username);

    @Query("select userinfo from TUserinfoEntity userinfo where userinfo.userid = :id ")
    public TUserinfoEntity findUserByID(@Param("id") int id);

}
