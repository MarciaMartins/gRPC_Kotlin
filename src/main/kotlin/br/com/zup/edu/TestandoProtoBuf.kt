package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(){
    val request = FuncionarioRequest.newBuilder()
        .setNome("01 Nome Funcionario")
        .setCpf("12345678901")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
                        .setLogradouro("Rua endereco")
                        .setCep("12345678")
                        .setComplemento("Casa 20")
                        .build())
        .build()

    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE).build()
    println(request2)
}