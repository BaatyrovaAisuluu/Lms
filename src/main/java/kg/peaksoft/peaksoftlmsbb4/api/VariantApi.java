package kg.peaksoft.peaksoftlmsbb4.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoft.peaksoftlmsbb4.db.dto.variant.VariantRequest;
import kg.peaksoft.peaksoftlmsbb4.db.dto.variant.VariantResponse;
import kg.peaksoft.peaksoftlmsbb4.db.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/variants")
@CrossOrigin(origins = "http//localhost:1234", maxAge = 3600)
@Tag(name = "Variant", description = "The Variant API")
public class VariantApi {
    private final VariantService variantService;

    @Operation(summary = "Add new variant",
            description = "This endpoint save new variant. Only users with role teacher can add new variant to question")
    @PostMapping("/{id}")
    public VariantResponse saveVariant(@PathVariable Long id, @RequestBody VariantRequest variantRequest) {
        return variantService.saveVariant(id, variantRequest);
    }

    @Operation(summary = "Gets a single variant by identifier",
            description = "For valid response try integer IDs with value >= 1 and...")
    @GetMapping("/{id}")
    public VariantResponse findById(@PathVariable Long id) {
        return variantService.findById(id);
    }

    @Operation(summary = "Update the variant",
            description = "Updates the details of an endpoint with ID")
    @PutMapping("/{id}")
    public VariantResponse updateVariant(@PathVariable Long id, @RequestBody VariantRequest variantRequest) {
        return variantService.update(id, variantRequest);
    }

    @Operation(summary = "Delete variant",
            description = "Delete the variant by ID")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        variantService.delete(id);
        return String.format("successful variant delete by id=%s", id);
    }
}
