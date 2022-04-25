package kg.peaksoft.peaksoftlmsbb4.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoft.peaksoftlmsbb4.db.dto.test.TestRequest;
import kg.peaksoft.peaksoftlmsbb4.db.dto.test.TestResponse;
import kg.peaksoft.peaksoftlmsbb4.db.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tests")
@CrossOrigin(origins = "http//localhost:1234", maxAge = 3600)
@Tag(name = "Test", description = "The Test API")
public class TestApi {
    private final TestService testService;

    @Operation(summary = "Add new test",
            description = "This endpoint create new test. Only users with role teacher can add new task to lesson")
    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/{id}")
    public TestResponse saveTest(@PathVariable Long id, @RequestBody TestRequest testRequest) {
        return testService.saveTest(id, testRequest);
    }

    @Operation(summary = "Gets a single tasks by identifier",
            description = "For valid response try integer IDs with value >= 1 and...")
    @PermitAll
    @GetMapping("/{id}")
    public TestResponse findById(@PathVariable Long id) {
        return testService.findById(id);
    }

    @Operation(summary = "Update test",
            description = "Updates the details of an endpoint with ID")
    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public TestResponse updateTest(@PathVariable Long id, @RequestBody TestRequest testRequest) {
        return testService.update(id, testRequest);
    }

    @Operation(summary = "Delete test",
            description = "Delete the test with id")
    @PreAuthorize("hasAuthority('TEACHER')")
    @DeleteMapping("/{id}")
    public String deleteTest(@PathVariable Long id) {
        testService.delete(id);
        return String.format("successfully delete this id=%s", id);
    }

}
