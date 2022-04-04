package vttp.paf.day11.bgg.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.paf.day11.bgg.model.Comment;
import vttp.paf.day11.bgg.model.Game;
import vttp.paf.day11.bgg.repo.GameRepo;

@Controller
public class GameController {

    @Autowired
    private GameRepo repo;

    @GetMapping(path = "/game")
    public String getGame(Model model, @RequestParam String gid) {
        Game game = new Game();
        Optional<Game> opt = repo.getGamebyGID(Integer.parseInt(gid));
        if (opt.isPresent()) {
            game = opt.get();
        } else {
            game.setName("No game found");
        }
        List<Comment> comments = repo.getCommentsByGID(Integer.parseInt(gid), 10, 0);
        model.addAttribute("game", game);
        model.addAttribute("comments", comments);
        return "result";
    }

    @GetMapping(path = "/game/{gid}")
    public String getGamePathVar(Model model, @PathVariable(name = "gid") String gid) {
        return getGame(model, gid);
    }
}
