package com.vitor.viacep.model;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    CepService cepService;

    public Menu(CepService cepService) {
        this.cepService = cepService;
    }

    public void showMenu() throws IOException, InterruptedException {

        try {

            System.out.println("Bem vindo ao programa de consulta de CEP!");
            System.out.println("1. Consultar CEP");
            System.out.println("2. Sair");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    cepService.searchZipCode();
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } catch (InputMismatchException e) {

            System.out.println("Algo deu errado! Verifique seu CEP, ele deve conter 8 digitos e somente números.");

        }



    }

}
