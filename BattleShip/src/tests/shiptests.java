package tests;
import com.company.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class shiptests {
    Ship B,C,CR,D,P,S;
    @BeforeEach
    void setUp() {
        B = new Battleship();
        C = new Carrier();
        CR = new Cruiser();
        D = new Destroyer();
        P = new Patrol();
        S = new Submarine();
    }
    @Test
    void hit() {
        int hp = B.getHP() - 1;
        B.hit();
        assertEquals(hp, B.getHP());
    }
    @Test
    void groupedAssertions() {
        assertAll("Test Props",
                () -> assertEquals("Battleship", B.getType(), "Type Failed"),
                () -> assertEquals(4, B.getSize(), "Wrong Battleship size"),
                () -> assertEquals("Carrier", C.getType(), "Type Failed"),
                () -> assertEquals(5, C.getSize(), "Wrong Carrier size"),
                () -> assertEquals("Cruiser", CR.getType(), "Type Failed"),
                () -> assertEquals(3, CR.getSize(), "Wrong Cruiser size"),
                () -> assertEquals("Destroyer", D.getType(), "Type Failed"),
                () -> assertEquals(3, D.getSize(), "Wrong  Destroyer size"),
                () -> assertEquals("Patrol", P.getType(), "Type Failed"),
                () -> assertEquals(2, P.getSize(), "Wrong Patrol size"),
                () -> assertEquals("Submarine", S.getType(), "Type Failed"),
                () -> assertEquals(3, S.getSize(), "Wrong Submarine size")

        );
    }

}
