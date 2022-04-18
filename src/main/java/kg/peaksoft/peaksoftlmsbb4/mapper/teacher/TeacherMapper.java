package kg.peaksoft.peaksoftlmsbb4.mapper.teacher;

import kg.peaksoft.peaksoftlmsbb4.converter.Converter;
import kg.peaksoft.peaksoftlmsbb4.converter.MyConverter;
import kg.peaksoft.peaksoftlmsbb4.dto.teacher.TeacherRequest;
import kg.peaksoft.peaksoftlmsbb4.dto.teacher.TeacherResponse;
import kg.peaksoft.peaksoftlmsbb4.enums.Role;
import kg.peaksoft.peaksoftlmsbb4.model.Teacher;
import kg.peaksoft.peaksoftlmsbb4.model.User;
import kg.peaksoft.peaksoftlmsbb4.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeacherMapper implements MyConverter<Teacher, TeacherRequest, TeacherResponse> {
    private final CourseRepository courseRepository;
    @Override
    public Teacher convert(Long id,TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getTeacherName());
        teacher.setLastName(request.getLastName());
        teacher.setPhoneNumber(request.getPhoneNumber());
        teacher.setSpecialization(request.getSpecialization());
        teacher.setCourse(courseRepository.getById(id));
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.TEACHER);
        teacher.setUser(user);

        return teacher;

    }

    @Override
    public TeacherResponse deConvert(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setTeacherName(teacher.getName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setPhoneNumber(teacher.getPhoneNumber());
        teacherResponse.setSpecialization(teacher.getSpecialization());
        teacherResponse.setEmail(teacher.getUser().getEmail());
        teacherResponse.setPassword(teacher.getUser().getPassword());
        teacherResponse.setRole(teacher.getUser().getRole());
        return teacherResponse;

    }
}