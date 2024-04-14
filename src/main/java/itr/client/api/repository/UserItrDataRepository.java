package itr.client.api.repository;

import itr.client.api.model.db.entity.UserItrData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserItrDataRepository extends JpaRepository<UserItrData, Integer> {
}
