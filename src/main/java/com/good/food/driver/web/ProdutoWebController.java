package com.good.food.driver.web;

import java.net.URI;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import com.good.food.adapter.controller.ProdutoController;
import com.good.food.adapter.controller.ProdutoControllerImpl;
import com.good.food.adapter.presenter.ProdutoPresenterImpl;
import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.application.presenter.produto.ProdutoPresenter;
import com.good.food.application.presenter.produto.ProdutoRequest;
import com.good.food.application.presenter.produto.ProdutoResponse;
import com.good.food.application.usecase.produto.BuscarProdutoPorCategoriaUseCase;
import com.good.food.application.usecase.produto.BuscarProdutoPorCategoriaUseCaseImpl;
import com.good.food.application.usecase.produto.CadastrarProdutoUseCase;
import com.good.food.application.usecase.produto.CadastrarProdutoUseCaseImpl;
import com.good.food.application.usecase.produto.EditarProdutoUseCase;
import com.good.food.application.usecase.produto.EditarProdutoUseCaseImpl;
import com.good.food.application.usecase.produto.RemoverProdutoUseCase;
import com.good.food.application.usecase.produto.RemoverProdutoUseCaseImpl;
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

@RestController
@RequestMapping("produto")
@Api(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoWebController {

    private final ProdutoController produtoController;

    public ProdutoWebController(ProdutoDatabaseGateway produtoDatabaseGateway) {
        final ProdutoPresenter produtoPresenter = new ProdutoPresenterImpl();

        // Os gateways devem ser injetados pelo Spring para o framework inicializar os repositórios.
        // Como a implementação dos gateways está na camada mais externa, isso não quebra nenhuma regra do clean architecture.

        // Aqui essa camada (mais externa) escolhe e instancia as implementações que serão usadas em todas as outras camadas.
        // Para trocar a implementação do banco de dados ou um presenter, por exemplo, basta trocar a instância aqui, que irá impactar apenas nesse controller REST.
        final CadastrarProdutoUseCase cadastrarProdutoUseCase = new CadastrarProdutoUseCaseImpl(produtoDatabaseGateway, produtoPresenter);
        final RemoverProdutoUseCase removerProdutoUseCase = new RemoverProdutoUseCaseImpl(produtoDatabaseGateway);
        final EditarProdutoUseCase editarProdutoUseCase = new EditarProdutoUseCaseImpl(produtoDatabaseGateway);
        final BuscarProdutoPorCategoriaUseCase buscarProdutoPorCategoriaUseCase = new BuscarProdutoPorCategoriaUseCaseImpl(produtoDatabaseGateway);

        this.produtoController = new ProdutoControllerImpl(cadastrarProdutoUseCase, //
                                                           removerProdutoUseCase, //
                                                           editarProdutoUseCase, //
                                                           buscarProdutoPorCategoriaUseCase, //
                                                           produtoPresenter);
    }

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
    @CacheEvict(value = "ProdutoResponse", allEntries = true)
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoController.cadastrarProduto(produtoRequest);
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
    @CacheEvict(value = "ProdutoResponse", allEntries = true)
    public ResponseEntity<Void> editarProduto(@PathVariable String id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        produtoController.editarProduto(produtoRequest);
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
    @Cacheable(value = "ProdutoResponse", key = "#categoria")
    public List<ProdutoResponse> buscarPorCategoria(@RequestParam String categoria) {
        return produtoController.buscarPorCategoria(categoria);
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
    @CacheEvict(value = "ProdutoResponse", allEntries = true)
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        produtoController.removerProduto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
