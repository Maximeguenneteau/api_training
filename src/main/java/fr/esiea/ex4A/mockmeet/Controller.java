package fr.esiea.ex4A.mockmeet;

import fr.esiea.ex4A.mockmeet.json.Match;
import fr.esiea.ex4A.mockmeet.json.User;
import fr.esiea.ex4A.mockmeet.tools.ResponseMatch;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @PostMapping(path = "api/inscription")
    void registerUser(@RequestBody User user){
        System.out.println(user);
    }

    @GetMapping(path = "api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Match> getMatches(String name, String country){

        return new ResponseMatch(new Match("Maxime", "Lulu"),
            new Match("Mario", "Luigi"),
            new Match("Maxence", "Marie"));
    }

}
