package com.vitor.viacep.model;

public record EnderecoDTO(String cep, String logradouro, String bairro, String localidade, String uf, String estado, String regiao, String ddd) {

}
