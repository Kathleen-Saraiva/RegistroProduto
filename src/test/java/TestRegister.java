import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestRegister {
    Register register = new Register();


    @Test
    public void testValidateStart(){
        Integer start = 1;
        String result =  register.validaStart(start);
        assertEquals(result,"Vamos começar");
    }
    @Test
    public void testEncerraStart(){
        Integer start = 2;
        String result =  register.validaStart(start);
        assertEquals(result,"Encerrado");
    }
    @Test
    public void testStartInvalido(){
        Integer start = 3;
        String result =  register.validaStart(start);
        assertEquals(result,"Digite uma opção valida");
    }
    @Test
    public void testValidaNome(){
        String nome = "Bala";
        boolean result =  register.validaNome(nome);
        assertEquals(result, true);
    }
    @Test
    public  void testInvalidNome(){
        String nome = "B";
        boolean result = register.validaNome(nome);
        assertEquals(result, false);
    }
    @Test
    public  void testValidaDesconto() {
        int price = 10;
        int desconto = 5;
        int result = register.validaDesconto(price, desconto);
        assertEquals(result, 5);
    }

    @Test
    public  void testInvalidDesconto(){
        int price = 10;
        int desconto = 20;
        int result =  register.validaDesconto(price, desconto);
        assertEquals(result, -1);
    }
    @Test
    public void testValidaProdutoSucess(){

        boolean result =  register.validaProduto("bala",10,5);

        assertEquals(result, true);
    }
    @Test
    public void testInvalidProduto(){
        boolean result =  register.validaProduto("b",10,5);

        assertEquals(result, false);
    }
    @Test
    public void testChamaMetodoValidaProduto(){
        Register classRegister =  Mockito.mock(Register.class);
        Mockito.verify(classRegister, Mockito.times(1)).validaProduto("bala",10,5 );
    }


}


