package com.veiculos.resources;

import com.veiculos.models.VeiculoModel;
import com.veiculos.repository.VeiculoRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoRepository vr;

    @Operation(description = "Buscar lista de veículos")
    @GetMapping(produces = "application/json")
    public @ResponseBody ArrayList<VeiculoModel> listaVeiculos(){
        Iterable<VeiculoModel> listaVeiculos = vr.findAll();
        ArrayList<VeiculoModel> veiculos = new ArrayList<VeiculoModel>();
        for (VeiculoModel veiculo : listaVeiculos){
            long codigo = veiculo.getCodigo();
            veiculo.add(linkTo(methodOn(VeiculoResource.class).veiculo(codigo)).withSelfRel());
            veiculos.add(veiculo);
        }
        return veiculos;
    }

    @Operation(description = "Buscar um veículo específico")
    @GetMapping(value = "/{codigo}", produces = "application/json")
    public @ResponseBody VeiculoModel veiculo(@PathVariable(value = "codigo") long codigo){
        VeiculoModel veiculo = vr.findByCodigo(codigo);
        veiculo.add(linkTo(methodOn(VeiculoResource.class).listaVeiculos()).withRel("Lista de Veículos"));
        return veiculo;
    }

    @Operation(description = "Cadastrar veículo")
    @PostMapping()
    public VeiculoModel cadastrarVeiculo(@RequestBody @Valid VeiculoModel veiculo){
        return vr.save(veiculo);
    }

    @Operation(description = "Deletar veículo")
    @DeleteMapping()
    public VeiculoModel deletarVeiculo(@RequestBody VeiculoModel veiculo){
        vr.delete(veiculo);
        return veiculo;
    }
}
