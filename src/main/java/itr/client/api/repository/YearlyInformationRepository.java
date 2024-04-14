package itr.client.api.repository;


import itr.client.api.model.db.entity.YearlyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearlyInformationRepository extends JpaRepository<YearlyInformation, Integer> {



}
