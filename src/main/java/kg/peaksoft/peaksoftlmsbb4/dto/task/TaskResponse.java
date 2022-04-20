package kg.peaksoft.peaksoftlmsbb4.dto.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String text;
    private String file;
    private String name;
    private String image;
    private String link;
    private String code;
}
