import java.util.Locale;
import java.text.NumberFormat;

public class Funcionario {
    private String idFuncionario;
    private String nomeFuncionario;
    private double salarioFuncionario;

    public Funcionario(){};

    public Funcionario(String idFuncionario, String nomeFuncionario, double salarioFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public String getSalarioFuncionario() {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(salarioFuncionario);
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void exibirDadosFuncionario() {
        System.out.println("ID do funcionário: " + idFuncionario);
        System.out.println("Nome do funcionário: " + nomeFuncionario);
        System.out.println("Salário do funcionário: " + getSalarioFuncionario());
    }


}
