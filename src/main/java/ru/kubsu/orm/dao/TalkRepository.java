package ru.kubsu.orm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kubsu.orm.entity.Talk;

import java.sql.Timestamp;

public interface TalkRepository extends CrudRepository<Talk, Long> {
    Iterable<Talk> findByDateBetween(Timestamp from, Timestamp to);
}
