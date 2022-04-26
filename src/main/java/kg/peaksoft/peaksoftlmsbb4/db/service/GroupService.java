package kg.peaksoft.peaksoftlmsbb4.db.service;

import kg.peaksoft.peaksoftlmsbb4.db.dto.group.GroupRequest;
import kg.peaksoft.peaksoftlmsbb4.db.dto.group.GroupResponse;
import kg.peaksoft.peaksoftlmsbb4.db.dto.student.StudentResponse;
import kg.peaksoft.peaksoftlmsbb4.db.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    GroupResponse saveGroup(GroupRequest groupRequest);

    List<GroupResponse> findAllGroup();

    GroupResponse findById(Long id);

    String deleteById(Long id);

    GroupResponse update(Long id, GroupRequest groupRequest);

    Group findBy(Long id);

    List<StudentResponse> getAllStudentByGroupId(Long id);

    void assignGroupToCourse(Long course, Long groupId);

}