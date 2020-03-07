package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.form.NoticeCredentials;
import ru.itmo.wp.repository.NoticeRepository;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public Notice add(NoticeCredentials noticeCredentials) {
        Notice notice = new Notice();
        notice.setContent(noticeCredentials.getContent());
        noticeRepository.save(notice);
        // userRepository.updatePasswordSha(user.getId(), userCredentials.getLogin(), userCredentials.getPassword());
        return notice;
    }

    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }
}
