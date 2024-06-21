package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"felipe", "julia"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("sucesso");

        }while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("contato " + candidato + " realizado na " + tentativasRealizadas + " tentativas");
        else
            System.out.println("contato " + candidato + " Nao realizado na " + tentativasRealizadas + " tentativas");

    }
    //metodo
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"felipe", "julia"};

        System.out.println("imprimindo lista com indiice de elemento");

        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("o candidato n " + (indice+1) + " é " + candidatos[indice]);
        }



    }


    static void selecaoCandidatos(){
        String [] candidatos = {"felipe", "julia", "paulo", "marcia", "sugusto", "monica", "daniela", "lucas","carla", "leticia", "alailton"};

        int candidatosSelecionados = 0;
        int candidatosAtual=0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 2 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("o candidato " + candidato + " solicitou esse valor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("o candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
            }
            candidatosAtual++;


        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }




    static void analisarCandidatos(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("ligar para candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("contraproposta ");
        } else {
            System.out.println("aguardar");
        }
    }
}