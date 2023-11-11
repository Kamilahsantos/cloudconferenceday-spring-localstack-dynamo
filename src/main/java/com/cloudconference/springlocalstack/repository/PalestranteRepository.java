package com.cloudconference.springlocalstack.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cloudconference.springlocalstack.model.Palestrante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PalestranteRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Palestrante salvar(Palestrante palestrante) {
        dynamoDBMapper.save(palestrante);
        return palestrante;
    }

    public Palestrante buscarPalestrantePeloId(String palestranteId) {
        return dynamoDBMapper.load(Palestrante.class, palestranteId);
    }

    public String excluir(String palestranteId) {
        Palestrante palestrante = dynamoDBMapper.load(Palestrante.class, palestranteId);
        dynamoDBMapper.delete(palestrante);
        return "Palestrante excluido do cadastro";
    }

    public Palestrante atualizar(String palestranteId, Palestrante palestrante) {
        dynamoDBMapper.save(new Palestrante
                        (palestranteId,palestrante.getNome(),
                                palestrante.getTema()),
                new DynamoDBSaveExpression()
                        .withExpectedEntry("palestranteId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(palestranteId)
                                )));
        return palestrante;
    }
}
