package itr.client.api.repository;


import itr.client.api.model.db.entity.YearlyDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface YearlyDocumentsRepository extends JpaRepository<YearlyDocument, Integer> {



}
