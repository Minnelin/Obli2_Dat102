
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ParentesSjekkTest {

    
    @Test
    public void korrektEnkelSteng() {
        assertTrue(ParentesSjekker.sjekkParentes("{ [ () ] }"));
    }

    @Test
    public void manglerSluttParentes() {
        assertFalse(ParentesSjekker.sjekkParentes("{ [ ( ) }"));
    }

    @Test
    public void manglerStartParentes() {
        assertFalse(ParentesSjekker.sjekkParentes("[ ( ) ] }"));
    }

    @Test
    public void feilRekkeFolge() {
        assertFalse(ParentesSjekker.sjekkParentes("{ [ ( ] ) }"));
    }

    @Test
    public void korrektJavaProgram() {
        String javaKode = "public class Test { public static void main(String[] args) { System.out.println(\"Hello\"); } }";
        assertTrue(ParentesSjekker.sjekkParentes(javaKode));
    }
}