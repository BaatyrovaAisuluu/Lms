package kg.peaksoft.peaksoftlmsbb4.db.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.peaksoft.peaksoftlmsbb4.annotations.phoneNumber.ValidPhoneNumber;
import kg.peaksoft.peaksoftlmsbb4.db.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    @Size(min = 2, max = 20, message = "first name should be between 2 and 20 characters")
    @JsonProperty("student_name")
    private String studentName;

    @NotBlank
    @Size(min = 2, max = 20, message = "last name should be between 2 and 20 characters")
    @JsonProperty("last_name")
    private String lastName;

   // @ValidPhoneNumber
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @Email(message = "email must follow the formatter :***@**")
    @NotEmpty(message = "email must have a value")
    private String email;

    private String password;

    private Long groupId;

}
