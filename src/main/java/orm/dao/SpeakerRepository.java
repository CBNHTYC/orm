package orm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import orm.entity.Speaker;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
}
