package kg.peaksoft.peaksoftlmsbb4.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponseDto {
    private String email;
    private String token;
}