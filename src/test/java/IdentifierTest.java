import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IdentifierTest {

    Identifier identifier;

    @Before
    public void inicializador(){
        identifier = new Identifier();
    }

    //(a1,Válido)
    @Test
    public void identificadorDeveriaSerValido(){
        Boolean validadorIdentificador = identifier.validaIdentificador("a1");
        assertEquals(true,validadorIdentificador);
    }

    //(2B3, Inválido)
    @Test(expected = IllegalArgumentException.class)
    public void identificadorDeveriaSerInvalidoPoisComecaComNumero(){
        identifier.validaIdentificador("2B3");
    }

    //(Z-12, Inválido)
    @Test(expected = IllegalArgumentException.class)
    public void identificadorDeveriaSerInvalidoPoisContemCaracteresInvalidos(){
        identifier.validaIdentificador("Z-12");
    }

    //(A1b2C3d, Inválido)
    @Test(expected = IllegalArgumentException.class)
    public void identificadorDeveriaSerInvalidoPoisUltrapassaTamanhoPermitido(){
        identifier.validaIdentificador("A1b2C3d");
    }

}
