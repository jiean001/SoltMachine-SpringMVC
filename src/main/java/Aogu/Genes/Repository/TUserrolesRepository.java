package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TUserrolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserrolesRepository extends JpaRepository<TUserrolesEntity,Integer>,JpaSpecificationExecutor<TUserrolesEntity> {
    @Query("select userrole from TUserrolesEntity userrole where userrole.roleid = :roleid ")
    public TUserrolesEntity findUserRoleByRoleID(@Param("roleid") int roleid);

    @Query("select userrole from TUserrolesEntity userrole where userrole.userid = :userid ")
    public TUserrolesEntity findUserRoleByUserID(@Param("userid") int userid);
}
