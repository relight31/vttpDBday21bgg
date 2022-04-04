package vttp.paf.day11.bgg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp.paf.day11.bgg.model.Comment;
import vttp.paf.day11.bgg.model.Game;
import vttp.paf.day11.bgg.repo.GameRepo;

@SpringBootTest
class BggApplicationTests {

	@Autowired
	private GameRepo repo;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnGame() {
		Optional<Game> opt = repo.getGamebyGID(10);
		assertTrue(opt.isPresent());
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt = repo.getGamebyGID(-1);
		assertFalse(opt.isPresent());
	}

	@Test
	void shouldReturnList() {
		List<Comment> comments = repo.getCommentsByGID(10);
		assertTrue(comments.size() > 0);
	}

	@Test
	void shouldReturnEmptyList() {
		List<Comment> comments = repo.getCommentsByGID(-1);
		assertTrue(comments.size() == 0);
	}
}
