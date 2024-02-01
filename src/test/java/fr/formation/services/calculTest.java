package fr.formation.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class calculTest {
    
    private calcul calc;

    @BeforeEach // C'est la methode qui sera execute avant chaque test
    void setUp() throws Exception {
        calc = new calcul();
    }

    @AfterEach // C'est la methode qui sera execute aprèS chaque test
	void tearDown() throws Exception {
		calc = null;
	}

    @DisplayName("Test de la méthode somme(...)")
    @RepeatedTest(3)
    void testSomme(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());

        System.out.println("*** REPETITION DETAILS ***");
		System.out.println("*** Répétition courante *** : " + repetitionInfo.getCurrentRepetition());
		System.out.println("*** Répétitions totales *** : " + repetitionInfo.getTotalRepetitions());
        
        assertTrue(calc.somme(0, 0) == 0, "entier x null");
        assertFalse(calc.somme(2, 3) == 6, "2 entiers positifs");
        assertNotNull(calc.somme(2, -3), "2 entiers designe differents");
        assertEquals(-5, calc.somme(-2, -3), "2 entiers négatifs");
    }

    @DisplayName("Test de la méthode division(...)")
	@Test
    void testDivision(TestInfo testInfo) {
        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
        
		assertEquals(2, calc.division(-6, -3), "2 entiers negatifs");
		assertNotNull(calc.division(-6, 3), "2 entiers de signe different");
        assertTrue(calc.division(0, 3) == 0, "entier x nul");
    }

    @DisplayName("Test de la methode division(...) - Exception attendue")
	@Test
	void testDivisionByZero(TestInfo testInfo) {
		System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
		
        assertThrows(ArithmeticException.class, () -> calc.division(2, 0));
	}
}
