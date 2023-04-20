    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     */
    package com.mycompany.aprendendojava;

    import java.util.Scanner;

    /**
     *
     * @author Gabriel
     */
    public class Aprendendojava {

        static Scanner s = new Scanner(System.in);
        static Scanner n = new Scanner(System.in);

        public static void cadastrar(String[] nomes, int[] cpf, int[] celular, float[] saldo, int[] pin, int i) {
             if (i >= nomes.length) {
        System.out.println("Limite de usuários atingido");
        return;
    }
            System.out.println("Informe seu nome");
            nomes[i] = s.nextLine();
            System.out.println("Informe seu CPF");
            cpf[i] = n.nextInt();
            System.out.println("Informe seu celular");
            celular[i] = n.nextInt();
             pin[i] = i;
            System.out.println("Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i] + "\nSaldo: " + saldo[i]);
            System.out.println("O seu número de segurança é: " + pin[i]);
             
        }

        public static float credito(float[] saldo) {
             System.out.println("Insira o número de segurança do usuário");
        int i = n.nextInt();
    
    System.out.println("Saldo atual: " + saldo[i]);
    System.out.println("Insira o quanto você deseja depositar:");
    float deposito = n.nextFloat();
    saldo[i] += deposito;
    
    System.out.println("Saldo atualizado: " + saldo[i]);
    return saldo[i];
        }

        public static float debito(float[] saldo) {
              System.out.println("Insira o número de segurança do usuário");
        int i = n.nextInt();
    
    System.out.println("Saldo atual: " + saldo[i]);
    System.out.println("Insira o quanto você deseja retirar:");
    float saque = n.nextFloat();
    saldo[i] -= saque;
    
    System.out.println("Saldo atualizado: " + saldo[i]);
    return saldo[i];
        }
       
            public static int atualizar_cel(int[] celular, int i) {
                System.out.println("Insira o número de segurança do usuário");
                i = n.nextInt();
                System.out.println("Numero atual: " + celular[i]);
                System.out.println("Insira o novo número: ");
                int novoNumero = n.nextInt();
                celular[i] = novoNumero;
               
                System.out.println("Número atualizado com sucesso para: " + celular[i]);
                return novoNumero;
            }
    public static void buscar_user(String[] nomes, int[] cpf, int[] celular, float[] saldo){
        System.out.println("Insira o cpf ou nome do usuario cadastrado que você deseja buscar: ");
        String user = s.nextLine();
     for(int i = 0; i < nomes.length; i++) {
        if(user.equals(nomes[i]) || user.equals(String.valueOf(cpf[i]))) {
            System.out.println("Usuário encontrado!");
            System.out.println("Nome: " + nomes[i] + "\nCPF: " + cpf[i] + "\nCelular: " + celular[i] + "\nSaldo: " + saldo[i]);
        }
    }
}
            
            public static void main(String[] args) {
                String nomes[] = new String[10];
                int celular[] = new int[10];
                int cpf[] = new int[10];
                float saldo[] = new float[10];
                int pin[]= new int[10];
                int op = 0;
                int i = 0;

                while (op != 7) {
                    System.out.println("--Banco Senac--");
                    System.out.println("escolha uma opção: \n");
                    System.out.println("1-Cadastrar\n2-Credito\n3-Debito\n4-Atualizar Celular\n5-Verificar usuario\n6-Verificar saldo\n7-Sair");
                    op = n.nextInt();
                    switch (op) {
                        case 1:
                            cadastrar(nomes, cpf, celular, saldo, pin,i);
                           i++;
                            break;
                        case 2:
                            saldo[i]=credito(saldo);
                            break;
                        case 3:        
                            saldo[i]=debito(saldo);  
                            break;
                        case 4:
                    celular[i] = atualizar_cel(celular,i);
                            break;
                        case 5:
                            buscar_user(nomes,cpf,celular,saldo);
                            break;
                    }

                }
            }
        }
