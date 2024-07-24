package com.good.food.driver.web.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.good.food.adapter.controller.ProdutoController;
import com.good.food.adapter.controller.request.ProdutoRequest;
import com.good.food.adapter.controller.response.ProdutoResponse;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
@Api(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoWebController {

    private final ProdutoController produtoController;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({ @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"), @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"), @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"), })
    @Operation(summary = "Criar produto.", description = "Cadastrar um produto no banco.")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoController.cadastrarProduto(produtoRequest);
        return ResponseEntity.created(URI.create("/" + produtoResponse.getUuid())).body(produtoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "Not found") })
    @PutMapping(path = "/{id}")
    @ApiImplicitParams({ @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"), @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"), @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"), })
    @Operation(summary = "Editar produto.", description = "Editar um produto no banco.")
    public ResponseEntity<Void> editarProduto(@PathVariable String id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        produtoController.editarProduto(UUID.fromString(id), produtoRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 404, message = "Not found") })
    @GetMapping(path = "/categoria")
    @Operation(summary = "Buscar produtos por categoria.", description = "Buscar produtos no banco por categoria.")
    public ResponseEntity<List<ProdutoResponse>> buscarPorCategoria(@RequestParam String categoria) {
        List<ProdutoResponse> produtos = produtoController.buscarPorCategoria(categoria);
        return ResponseEntity.ok().body(produtos);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 404, message = "Not found") })
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Remover produto.", description = "Remover um produto do banco.")
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        produtoController.removerProduto(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
