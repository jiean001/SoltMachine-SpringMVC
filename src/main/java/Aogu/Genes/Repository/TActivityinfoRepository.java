package Aogu.Genes.Repository;

import Aogu.Genes.Domain.TActivityinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TActivityinfoRepository extends JpaRepository<TActivityinfoEntity,Integer>,JpaSpecificationExecutor<TActivityinfoEntity> {
}
