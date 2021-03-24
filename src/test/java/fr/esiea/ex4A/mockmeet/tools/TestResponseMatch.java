package fr.esiea.ex4A.mockmeet.tools;

import fr.esiea.ex4A.mockmeet.json.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TestResponseMatch {

    @ParameterizedTest
    @ValueSource(strings = {"""
        Nom,Twitteur
        Samba,LeLion
        Mazen,Hotdog26
        Yannis,Xneon
        """, """
        Vald,Poutine
        Jamy,Wizard
        Soka,Fuji
        """
    })
    void matchesresponse_filling_list_test(String NomNTwitter){
        List<Match> identifiants = Arrays.stream(NomNTwitter.split("\n")).map(s -> {
            String[] kv = s.split(",");
            return new Match(kv[0],kv[1]);
        }).collect(Collectors.toList());

        ResponseMatch matches = new ResponseMatch(identifiants);

        matches.forEach(m -> assertTrue(identifiants.contains(m)));

    }
    @ParameterizedTest
    @CsvSource({
        "vlad,Poutine,Jamy,Wizard,Soka,Fuji"
    })
    void matchesresponse_mult_val_test(String Nom1, String Twitter1, String Nom2, String Twitter2, String Nom3, String Twitter3){
        List<Match> identifiants = Arrays.asList(new Match(Nom1, Twitter1),
            new Match(Nom2, Twitter2),
            new Match(Nom3, Twitter3));
        ResponseMatch matches = new ResponseMatch(identifiants.get(0),
            identifiants.get(1),
            identifiants.get(2));

        matches.forEach(m -> assertTrue(identifiants.contains(m)));
    }

}
