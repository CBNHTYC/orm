package ru.kubsu.orm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kubsu.orm.entity.Speaker;
import ru.kubsu.orm.entity.Talk;

import java.sql.Timestamp;

@Service
@EnableJpaRepositories
public class OrmDao {
    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private TalkRepository talkRepository;

    public void createSpeakers() {
        Speaker pavel = new Speaker("mr Pavel Dutkov");
        speakerRepository.save(pavel);

        Speaker evgeny = new Speaker("mr Evgeny Khabarov");
        speakerRepository.save(evgeny);

        Speaker nikolay = new Speaker("mr Nikolay Gurin");
        speakerRepository.save(nikolay);

        Speaker alex = new Speaker("mr Alex Shmidt");
        speakerRepository.save(alex);
    }

    public Iterable<Speaker> speakers(){
        return speakerRepository.findAll();
    }

    @Transactional
    public void createTalks() {

        Speaker evgeny = speakerRepository.findByName("mr Evgeny Khabarov");

        Talk talk1 = new Talk("ORM intro", new Timestamp(2019, 5, 5, 12, 0, 0, 0));
        Talk talk2 = new Talk("Spring data", new Timestamp(2019, 5, 5, 15, 45, 0, 0));
        talk1.setSpeaker(evgeny);
        talk2.setSpeaker(evgeny);
        talkRepository.save(talk1);
        talkRepository.save(talk2);

        Speaker nikolay = speakerRepository.findByName("mr Nikolay Gurin");

        talk1 = new Talk("Welcome to Hibernate", new Timestamp(2019, 5, 6, 10, 0, 0, 0));
        talk1.setSpeaker(nikolay);
        talkRepository.save(talk1);

        Speaker alex = speakerRepository.findByName("mr Alex Shmidt");
        talk1 = new Talk("SLF4J", new Timestamp(2019, 5, 6, 9, 30, 0, 0));
        talk2 = new Talk("Spring testing", new Timestamp(2019, 5, 5, 18, 0, 0, 0));
        talk1.setSpeaker(alex);
        talk2.setSpeaker(alex);
        talkRepository.save(talk1);
        talkRepository.save(talk2);
    }

    @Transactional
    public void showSpeakersAndTalks(){
        Iterable<Speaker> speakers = speakers();
        for (Speaker speaker : speakers){
            System.out.println(speaker.getName());
            System.out.println("**************");
            speaker.getTalks().forEach(talk -> System.out.println(talk.getTitle()));
            System.out.println("**************" + "\n");
        }
    }

    @Transactional
    public void showTalksByDateBetween(Timestamp from, Timestamp to){
        Iterable<Talk> talks = talkRepository.findByDateBetween(from,to);
        talks.forEach(talk -> System.out.println(talk.getSpeaker().getName() + " : " + talk.toString()));
    }

    @Transactional
    public void showSpeakersWithEnding(String ending){
        Iterable<Speaker> speakers = speakerRepository.findByNameEndingWith(ending);
        speakers.forEach(speaker -> System.out.println(speaker.toString()));
    }
}
