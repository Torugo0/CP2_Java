// Vitor Hugo Gonçalves Rodrigues - RM: 97758
// Leticia Cristina Gandarez Resina - RM: 98069

package br.com.fiap.main;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import br.com.fiap.bean.Aluno;

public class UsaAluno {
    public static void main(String[] args) {
        String nome, guardaData, aux;
        int rm;
        LocalDate dataNascimento;
        LocalDate dataAtual = LocalDate.now();

        try {
            // Declaração, instanciação e exibição de dois objetos com constructor vazio.
            Aluno vitor = new Aluno();
            Aluno leticia = new Aluno();

            vitor.setNome("Vitor Hugo Gonçalves Rodrigues");
            vitor.setRm(97758);
            vitor.setDataDeNascimento(LocalDate.parse("2005-03-08")); 
            
            leticia.setNome("Leticia Cristina Gandarez Resina");
            leticia.setRm(98069);
            leticia.setDataDeNascimento(LocalDate.parse("2004-08-04"));

            JOptionPane.showMessageDialog(null, "RM: " + vitor.getRm() + " - NOME: " + vitor.getNome() + " - IDADE COMPLETA: " + vitor.calculaIdadeCompleta(dataAtual));
            JOptionPane.showMessageDialog(null, "RM: " + leticia.getRm() + " - NOME: " + leticia.getNome() + " - Idade completa: " + leticia.calculaIdadeCompleta(dataAtual));      
            
            // Declaração, instanciação e exibição de dois objetos com constructor com passagem de parametros.
            
            // Pessoa 1
            nome = JOptionPane.showInputDialog("Digite seu nome:");
            rm = Integer.parseInt(JOptionPane.showInputDialog("Informe seu RM:"));

            aux = JOptionPane.showInputDialog("Informe sua data de nascimento:");
            guardaData = aux.substring(6,10); //2024
            guardaData += "-" + aux.substring(3, 5); // 2024-11
            guardaData += "-" + aux.substring(0, 2); // 2024-11-04

            dataNascimento = LocalDate.parse(guardaData);
            Aluno p1 = new Aluno(nome, rm, dataNascimento);

            // Pessoa 2
            nome = JOptionPane.showInputDialog("Digite seu nome:");
            rm = Integer.parseInt(JOptionPane.showInputDialog("Informe seu RM:"));

            aux = JOptionPane.showInputDialog("Informe sua data de nascimento:");
            guardaData = aux.substring(6,10); //2024
            guardaData += "-" + aux.substring(3, 5); // 2024-11
            guardaData += "-" + aux.substring(0, 2); // 2024-11-04

            dataNascimento = LocalDate.parse(guardaData);
            Aluno p2 = new Aluno(nome, rm, dataNascimento);

            // Exibindo informações
            JOptionPane.showMessageDialog(null, "RM: " + p1.getRm() + " - NOME: " + p1.getNome() + " - IDADE COMPLETA: " + p1.calculaIdadeCompleta(dataAtual));
            JOptionPane.showMessageDialog(null, "RM: " + p2.getRm() + " - NOME: " + p2.getNome() + " - Idade completa: " + p2.calculaIdadeCompleta(dataAtual));  

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}