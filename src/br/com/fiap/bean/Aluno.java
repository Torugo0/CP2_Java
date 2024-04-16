// Vitor Hugo Gonçalves Rodrigues - RM: 97758
// Leticia Cristina Gandarez Resina - RM: 98069

package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class Aluno {
    private int rm;
    private String nome;
    private LocalDate dataDeNascimento;

    public Aluno(){} //Criação de constructors vazio e com passagem de parametros

    public Aluno(String nome, int rm, LocalDate dataDeNascimento){
        this.nome = nome;
        setRm(rm); // Não coloco um this.rm = rm; porque ele precisa passar pela verificação antes de definir o rm.
        setDataDeNascimento(dataDeNascimento); // A mesma coisa serve para a data de nascimento.
    }

    public int getRm() {
        return rm;
    }
    public void setRm(int rm) {
        try {
            if (rm >= 97001 && rm <= 551999) {
                this.rm = rm;
            } else {
                throw new Exception("RM INVÁLIDO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        LocalDate minimo = LocalDate.parse("1899-12-31");
        LocalDate dataAtual = LocalDate.now(); // Pega a data atual do sistema
        try {
            if (dataDeNascimento.isAfter(minimo) && dataDeNascimento.isBefore(dataAtual)) {
                this.dataDeNascimento = dataDeNascimento; // Caso esteja tudo dentro da regra de negocios ele setta a data.
            } else {
                throw new Exception("Data fora da faixa permitida (01/01/1900" + " - " + dataAtual.getDayOfMonth() +"/0"+dataAtual.getMonthValue()+"/"+dataAtual.getYear()+ ")");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }}

        public String calculaIdadeCompleta(LocalDate dataAtual) {
            Period periodo = Period.between(dataDeNascimento, dataAtual);
            
            String idadeCompleta = periodo.getYears() + " anos, " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias";

            return idadeCompleta;
        }
}
