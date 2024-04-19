package com.conversor.moeda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarMoeda consultaMoeda = new ConsultarMoeda();
        List<Moeda> conversoes = new ArrayList<>();
        try {
            while (true) {
                System.out.println("\n--- Conversor de Moedas ---");
                System.out.println("1. USD para BRL");
                System.out.println("2. BRL para USD");
                System.out.println("3. EUR para USD");
                System.out.println("4. USD para EUR");
                System.out.println("5. EUR para BRL");
                System.out.println("6. BRL para EUR");
                System.out.println("7. GBP para AUD");
                System.out.println("8. AUD para GBP");
                System.out.println("0. Sair");
                System.out.print("Escolha a opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 0) {
                    System.out.println("Saindo do conversor...");
                    break;
                }
                System.out.print("Digite o valor a converter: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                String base_code = "", target_code = "";
                if (opcao == 1) {
                    base_code = "USD";
                    target_code = "BRL";
                }else if (opcao == 2) {
                    base_code = "BRL";
                    target_code = "USD";
                }else if (opcao == 3) {
                    base_code = "EUR";
                    target_code = "USD";
                }else if (opcao == 4) {
                    base_code = "USD";
                    target_code = "EUR";
                }else if (opcao == 5) {
                    base_code = "EUR";
                    target_code = "BRL";
                }else if (opcao == 6) {
                    base_code = "BRL";
                    target_code = "EUR";
                } else if (opcao == 7) {
                    base_code = "GBP";
                    target_code = "AUD";
                }else if (opcao == 8) {
                    base_code = "AUD";
                    target_code = "GBP";
                }
                Moeda novaMoeda = consultaMoeda.buscaMoeda(base_code, target_code, valor);
                System.out.printf("O valor convertido de %s para %s é: %s\n",
                        base_code, target_code, novaMoeda.conversion_result());
                conversoes.add(novaMoeda);
            }
            GeradordeArquivo gerador = new GeradordeArquivo();
            gerador.salvaJson(conversoes);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}