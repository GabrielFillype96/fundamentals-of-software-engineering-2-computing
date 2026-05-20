public class Pessoa {
    private String nome;
    private String pais;
    private int idade;
    
    public Pessoa(){}

    public Pessoa(String nome, String pais, int idade) {
        this.nome = nome;
        this.pais = pais;
        this.idade = idade;
    }

    public void nomeValidacao(String nome) {
        if (nome !=null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Nome inválido.");
        }
    }

    public void paisValidacao(String pais) {
        if (pais != null && !pais.isEmpty()) {
            this.pais = pais;
        } else {
            System.out.println("País inválido.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public String getPais() {
        return pais;
    }
    public int getIdade() {
        return idade;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("País: " + pais);
        System.out.println("Idade: " + idade);
    }

}
