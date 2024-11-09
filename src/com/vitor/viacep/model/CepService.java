package com.vitor.viacep.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CepService {


    public void searchZipCode() throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CEP: ");

        int cep = scanner.nextInt();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

                HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        EnderecoDTO enderecotd = gson.fromJson(responseBody, EnderecoDTO.class);

        if (enderecotd == null || enderecotd.cep() == null) {
            System.out.println("CEP inválido ou inexistente.");
            return;
        }

        FileWriter json = new FileWriter("endereco.json");

        json.write(gson.toJson(enderecotd));

        json.close();

        System.out.println("\nEndereço encontrado! Todas as informações foram gravadas no arquivo 'endereco.json'.");

    }

}
