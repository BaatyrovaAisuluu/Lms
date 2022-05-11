package kg.peaksoft.peaksoftlmsbb4.db.service;

import kg.peaksoft.peaksoftlmsbb4.db.dto.link.LinkRequest;
import kg.peaksoft.peaksoftlmsbb4.db.dto.link.LinkResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LinkService {
    LinkResponse saveLinks(LinkRequest linkRequest);

    LinkResponse findById(Long id);

    LinkResponse update(Long id, LinkRequest linkRequest);

    String delete(Long id);

    LinkResponse findLinkByLessonId(Long id);
}
