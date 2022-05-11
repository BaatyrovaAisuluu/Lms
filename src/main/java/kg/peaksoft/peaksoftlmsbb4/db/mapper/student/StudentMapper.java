package kg.peaksoft.peaksoftlmsbb4.db.mapper.student;

import kg.peaksoft.peaksoftlmsbb4.db.converter.Converter;
import kg.peaksoft.peaksoftlmsbb4.db.dto.student.StudentRequest;
import kg.peaksoft.peaksoftlmsbb4.db.dto.student.StudentResponse;
import kg.peaksoft.peaksoftlmsbb4.db.enums.Role;
import kg.peaksoft.peaksoftlmsbb4.db.model.Student;
import kg.peaksoft.peaksoftlmsbb4.db.model.User;
import kg.peaksoft.peaksoftlmsbb4.db.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class StudentMapper implements Converter<Student, StudentRequest, StudentResponse> {
    private final GroupRepository groupRepository;
    @Override
    public Student convert(StudentRequest studentRequest) {
        Student student = new Student();
        User user = new User();
        student.setStudentName(studentRequest.getStudentName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setGroup(groupRepository.getById(studentRequest.getGroupId()));
        user.setRole(Role.STUDENT);
        user.setPassword(studentRequest.getPassword());
        user.setEmail(studentRequest.getEmail());
        student.setUser(user);
        return student;
    }

    @Override
    public StudentResponse deConvert(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setStudentName(student.getStudentName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setPhoneNumber(student.getPhoneNumber());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setRole(student.getUser().getRole());
        studentResponse.setEmail(student.getUser().getEmail());
        return studentResponse;
    }

    public List<StudentResponse> deConvert(List<Student> students){
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student s:students) {
            studentResponses.add(deConvert(s));
        }
        return studentResponses;
    }
}
