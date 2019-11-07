package com.aws.trailix.services.impl;

import com.aws.trailix.services.S3Service;

public class S3ServiceImpl implements S3Service {
    @Override
    public void upload() {

    }


}


class Cursos {
    String nome;
    int alunos;

    Cursos(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }
}