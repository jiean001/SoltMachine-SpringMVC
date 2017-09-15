package Aogu.Genes.Service;


import Aogu.Genes.Domain.TUserrolesEntity;
import Aogu.Genes.Repository.TUserrolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TUserrolesService {
    @Autowired
    private TUserrolesRepository tUserrolesRepository;

    public TUserrolesEntity findUserRoleByRoleID(int roleid ){
        TUserrolesEntity userrole=tUserrolesRepository.findUserRoleByRoleID(roleid);
        return userrole;
    }


    public TUserrolesEntity findUserRoleByUserID(int userid ){
        TUserrolesEntity userrole=tUserrolesRepository.findUserRoleByUserID(userid);
        return userrole;
    }

    public void add(TUserrolesEntity userrole)
    {
        tUserrolesRepository.save(userrole);
    }
}
