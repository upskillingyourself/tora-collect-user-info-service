package itr.client.api.repository;

import itr.client.api.model.db.entity.PermanentDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermanentDocumentsRepository extends JpaRepository<PermanentDocuments, Long> {



}