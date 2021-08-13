package br.com.zup.edu

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder


fun main(){

    val channel = ManagedChannelBuilder
                    .forAddress("localhost", 50051)
                    .usePlaintext()
                    .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val request = FuncionarioRequest.newBuilder()
        .setNome("01 Nome Funcionario")
        .setCpf("12345678901")
        .setIdade(23)
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua endereco")
            .setCep("12345678")
            .setComplemento("Casa 20")
            .build())
        .build()
    val response = client.cadastrar(request)

    println(response)
}