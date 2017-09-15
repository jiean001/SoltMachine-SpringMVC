package Aogu.Genes.Service;


import Aogu.Genes.Domain.TUserinfoEntity;
import Aogu.Genes.Repository.TUserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TUserinfoService {
    @Autowired
    private TUserinfoRepository tUserinfoRepository;

    public TUserinfoEntity findUserByusername(String username ){
        TUserinfoEntity userinfo=tUserinfoRepository.findUserByuserName(username);
        return userinfo;
    }


    public TUserinfoEntity findUserByID(int id ){
        TUserinfoEntity userinfo=tUserinfoRepository.findUserByID(id);
        return userinfo;
    }

    public void add(TUserinfoEntity userinfo)
    {
        tUserinfoRepository.save(userinfo);
    }
}
