package fr.esiea.ex4A.mockmeet.tools;

import fr.esiea.ex4A.mockmeet.json.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseMatch extends ArrayList<Match> {

    public ResponseMatch(List<Match> matches){
        super();
        this.addAll(matches);
    }

    public ResponseMatch(Match... matches){
        super();
        this.addAll(Arrays.asList(matches));
    }
}
