import java.util.Scanner;

public class Register {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Integer start =  0;
        String nomeProduto;
        int price;
        int desconto;

        while(start !=  1) {
            System.out.println("Bem vindo ao validador de registro para produtos,\n" +
                    "Selecione a opção desejada:\n" +
                    "1 - Começar a validar\n" +
                    "2 - Encerrar.\n");

            start = input.nextInt();
            String validate = validaStart(start);
            if(validate == "Encerrado") return;
        }
        System.out.println("Digite o nome do produto sem espaços:");
        nomeProduto =  input.next();

        System.out.println("Digite o preço do produto:");
        price = input.nextInt();

        System.out.println("Digite o valor de desconto:");
        desconto = input.nextInt();

        validaProduto(nomeProduto, price,desconto);
    }
    public static boolean validaProduto(String nomeProduto, int price, int desconto){

        Boolean validateNome =  validaNome(nomeProduto);
        if(validateNome == false) return false;

        Integer resultDesconto =  validaDesconto(price, desconto);

        if(resultDesconto == -1) {
            System.out.println("Desconto é maior que o preço");
            return false;
        };
        System.out.println("Produto validado com sucessp");
        return  true;
    }
    public static String validaStart(int start){
        if(start == 1){
            return "Vamos começar";
        }else if(start == 2){
            return  "Encerrado";
        }else{
            return  "Digite uma opção valida";
        }
    }

    public static boolean validaNome(String nome){
        if(nome.length() < 2){
            System.out.println("Nome "+nome+" invalido");
            return false;
        }
        return  true;
    }

    public static int validaDesconto(int price, int desconto){
        if (desconto > price ) return -1;
        int result = price - desconto;
        System.out.println("O valor do seu produto com desconto é "+ result);
        return result;
    }

}
