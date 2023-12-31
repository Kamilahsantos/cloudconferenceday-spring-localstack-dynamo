package com.cloudconference.springlocalstack.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "palestrante")
public class Palestrante {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String palestranteId;

    @DynamoDBAttribute
    private String nome;


    @DynamoDBAttribute
    private String tema;

    public String getPalestranteId() {
        return palestranteId;
    }

    public void setPalestranteId(String palestranteId) {
        this.palestranteId = palestranteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }


    public Palestrante(String palestranteId, String nome, String tema) {
        this.palestranteId = palestranteId;
        this.nome = nome;
        this.tema = tema;
    }

    public Palestrante() {
    }

}
