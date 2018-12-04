package evaluateur;

//import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.hamcrest.core.Is.*;


@DisplayName("Tests fonctionnels de la classe EvaluateurNiveau")
class EvaluateurNiveauTest {

private static EvaluateurNiveau evaluateur;

@BeforeAll
 public static void setEvaluateurNiveau() {
    evaluateur = EvaluateurNiveau.getEvaluateurNiveau();
    }

    @DisplayName("Tests aux limites EvaluateurNiveau")
    @ParameterizedTest(name = "{index} => cours={0}, examen={1}, attendu={2}")
    @CsvFileSource(resources = "/test-data-examen.csv")
    void testsLimitesEvaluateurNiveau( String cours , String examen , String attendu) throws Exception {
//        assertEquals( evaluateur.evaluerNiveau(cours, examen) , attendu );
    	assertThat( evaluateur.evaluerNiveau(cours, examen) , is(attendu) );
    }
    
    @Test
    public void testMauvaisFormatCours() {
     Assertions.assertThrows(Exception.class, () -> {
     evaluateur.evaluerNiveau("1C", "70");
        });
    }
      
    @Test
    public void testValeurHorsBornesExamen() {
     Assertions.assertThrows(Exception.class, () -> {
     evaluateur.evaluerNiveau("20", "76");
     });
    }    
}
