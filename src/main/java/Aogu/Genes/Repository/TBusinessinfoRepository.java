package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TBusinessinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TBusinessinfoRepository extends JpaRepository<TBusinessinfoEntity,Integer>,JpaSpecificationExecutor<TBusinessinfoEntity> {
    //找到id为fatherid的运营商的所有直属运营商
    @Query("select businesses from TBusinessinfoEntity businesses where businesses.fatherbusinessid = :fatherid ")
    public TBusinessinfoEntity findTBusinessesByFatherID(@Param("fatherid") int fatherid);

    @Query("select business from TBusinessinfoEntity business where business.businessname=?1 and business.valid=0 ")
    TBusinessinfoEntity findBusinessByName(String businessname);

    @Query("select business from TBusinessinfoEntity business where business.businessid=?1 and business.valid=0 ")
    TBusinessinfoEntity findBusinessById(int businessid);

    @Query("select businesses from TBusinessinfoEntity businesses where  businesses.userid = :userid")
    public TBusinessinfoEntity findBusinessByOrgUserID(@Param("userid") int userid);

    @Query("select businesses from TBusinessinfoEntity businesses,TBusinessmaninfoEntity businessmaninfo where businessmaninfo.user.userid = :userid and businesses.businessid = businessmaninfo.businessid")
    public TBusinessinfoEntity findBusinessByUserID(@Param("userid") int userid);

}


