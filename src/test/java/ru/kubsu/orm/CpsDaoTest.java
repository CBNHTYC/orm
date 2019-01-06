package ru.kubsu.orm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kubsu.orm.dao.OrmDao;
import ru.kubsu.orm.entity.Speaker;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CpsDaoTest {
    @Autowired
    OrmDao ormDao;

    @Test
    public void SomeTest(){
        ormDao.showSpeakersWithEnding("ov");
    }

}
