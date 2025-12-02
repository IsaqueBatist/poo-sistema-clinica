package fatec.poo.model;

/**
 * 
 * @author Victor Leonardo
 * 
 */
public class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;     
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }
    
    
    
    public static boolean validarCPF(String cpf){
        int soma = 0;
        int totaisIguais = 0;
        
        if(cpf.length() != 11) return false;
        
        for (int i = 0; i < 10; i++) {
           if(String.valueOf(cpf.charAt(i))
                   .equals(String.valueOf(cpf.charAt(i+1)))) totaisIguais++; 
        }

        if(totaisIguais == 10) return false;
        
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (i + 1);
        }
        
        int primeiroNumeroVerificador = soma%11;
        
        if(primeiroNumeroVerificador == 10) primeiroNumeroVerificador = 0;
        
        soma = 0;
        
        soma += primeiroNumeroVerificador * 2;
        
        int j = 11;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * j--;
        }

        int segundoNumeroVerificador = (soma * 10) % 11;
        
        if(segundoNumeroVerificador == 10) segundoNumeroVerificador = 0;
        
       return Character.getNumericValue(cpf.charAt(9)) == primeiroNumeroVerificador 
               && Character.getNumericValue(cpf.charAt(10)) == segundoNumeroVerificador;
    }
}
