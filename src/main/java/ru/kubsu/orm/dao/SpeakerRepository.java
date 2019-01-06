package ru.kubsu.orm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kubsu.orm.entity.Speaker;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
    Speaker findByName(String name);

    Iterable<Speaker> findByNameEndingWith(String ending);
}
