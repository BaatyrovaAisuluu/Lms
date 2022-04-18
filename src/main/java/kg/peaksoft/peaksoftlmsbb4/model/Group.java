package kg.peaksoft.peaksoftlmsbb4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String groupName;
    private String description;
    private String imagine;
    private LocalDate dateOfStart;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    public void setCourse(Course course) {
        if (course == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroup(this);
    }
}