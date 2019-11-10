package ru.itmo.wp.model.service;

import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.repository.TalkRepository;
import ru.itmo.wp.model.repository.impl.TalkRepositoryImpl;

import java.util.List;

public class TalkService {
    private final TalkRepository talkRepository = new TalkRepositoryImpl();
    public void createTalk(Talk talk) {
        talkRepository.save(talk);
    }
    public List<Talk> findTalksByUserId(long userId) {
        return talkRepository.findAllByUserId(userId);
    }
}
