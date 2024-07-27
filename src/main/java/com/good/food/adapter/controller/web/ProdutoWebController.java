package com.good.food.adapter.controller.web;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.good.food.usecase.usecase.produto.BuscarProdutoPorCategoriaUseCase;
import com.good.food.usecase.usecase.produto.CadastrarProdutoUseCase;
import com.good.food.usecase.usecase.produto.EditarProdutoUseCase;
import com.good.food.usecase.usecase.produto.RemoverProdutoUseCase;
import com.good.food.usecase.usecase.produto.request.ProdutoRequest;
import com.good.food.usecase.usecase.produto.response.ProdutoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
@Api(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoWebController {

    private final CadastrarProdutoUseCase cadastrarProduto;
    private final RemoverProdutoUseCase removerProduto;
    private final EditarProdutoUseCase editarProduto;
    private final BuscarProdutoPorCategoriaUseCase buscarProdutoPorCategoria;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"),
            @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"),
    })
    @Operation(
            summary = "Criar produto",
            description = "Cadastrar um produto",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Produto a ser cadastrado",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProdutoRequest.class),
                            examples = @ExampleObject(
                                    value = "{ \"descricao\": \"Coca-cola\", \"preco\": 10.00, \"categoria\": \"BEBIDA\" }"
                            )
                    )
            )
    )
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = cadastrarProduto.execute(produtoRequest);
        return ResponseEntity.created(URI.create("/" + produtoResponse.getUuid())).body(produtoResponse);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PutMapping(path = "/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"),
            @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"),
    })
    @Operation(
            summary = "Editar produto",
            description = "Editar um produto",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Produto a ser editado",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProdutoRequest.class),
                            examples = @ExampleObject(
                                    value = "{ \"descricao\": \"Coca-cola\", \"preco\": 10.00, \"categoria\": \"BEBIDA\" }"
                            )
                    )
            )
    )
    public ResponseEntity<Void> editarProduto(@PathVariable String id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        editarProduto.execute(UUID.fromString(id), produtoRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping(path = "/categoria")
    @Operation(
            summary = "Buscar produtos por categoria",
            description = "Buscar produtos por categoria",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "categoria",
                    description = "Categoria do produto",
                    required = true,
                    example = "BEBIDA"
            )
    )
    public ResponseEntity<List<ProdutoResponse>> buscarPorCategoria(@RequestParam String categoria) {
        List<ProdutoResponse> produtos = buscarProdutoPorCategoria.execute(categoria);
        return ResponseEntity.ok().body(produtos);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Remover produto",
            description = "Remover um produto",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "id",
                    description = "ID do produto",
                    required = true,
                    example = "123e4567-e89b-12d3-a456-426614174000"
            )
    )
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        removerProduto.execute(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
