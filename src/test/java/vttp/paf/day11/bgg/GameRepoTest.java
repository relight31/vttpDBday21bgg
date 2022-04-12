package vttp.paf.day11.bgg;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import vttp.paf.day11.bgg.repo.GameRepo;

@SpringBootTest
public class GameRepoTest {
    // mock the repository layer
    @MockBean
    private GameRepo repo;

    // define methods + params + expected return
    // can return values/throw exceptions

    @Test
    public void shouldReturnOptionalEmpty() {
        Mockito.when(repo.getGamebyGID(-500)).thenReturn(Optional.empty());
        assertFalse(repo.getGamebyGID(-500).isPresent());
    }

    /*
     * if you have tests with service and repo layer, mockito the repo method in
     * every test with the service layer
     */
}
