package com.cloudconference.springlocalstack.controller;


import com.cloudconference.springlocalstack.model.Palestrante;
import com.cloudconference.springlocalstack.repository.PalestranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PalestranteController {

    @Autowired
    private PalestranteRepository palestranteRepository;

    @PostMapping("/palestrantes")
    public Palestrante salvarPalestrante(@RequestBody Palestrante palestrante) {
        return palestranteRepository.salvar(palestrante);
    }

    @GetMapping("/palestrantes/{id}")
    public Palestrante buscarPalestrantePeloId(@PathVariable("id") String palestranteId) {
        return palestranteRepository.buscarPalestrantePeloId(palestranteId);
    }

    @DeleteMapping("/palestrantes/{id}")
    public String apagarPalestrante(@PathVariable("id") String palestranteId) {
        return  palestranteRepository.excluir(palestranteId);
    }

    @PutMapping("/palestrantes/{id}")
    public Palestrante atualizarPalestrante(@PathVariable("id") String palestranteId,
                                     @RequestBody Palestrante palestrante) {
        return palestranteRepository.atualizar(palestranteId, palestrante);
    }

}
