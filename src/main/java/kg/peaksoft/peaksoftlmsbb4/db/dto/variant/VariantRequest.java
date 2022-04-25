package kg.peaksoft.peaksoftlmsbb4.db.dto.variant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariantRequest {
    @JsonProperty("variant_name")
    private String variantName;
    @JsonProperty("is_true")
    private Boolean isTrue = false;
}
