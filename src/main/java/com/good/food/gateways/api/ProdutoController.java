package com.good.food.gateways.api;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.good.food.gateways.api.request.ProdutoRequest;
import com.good.food.gateways.api.response.ProdutoResponse;
import com.good.food.usecase.CadastrarProdutoUseCase;
import com.good.food.usecase.EditarProdutoUseCase;
import com.good.food.usecase.RemoverProdutoUseCase;
import com.good.food.usecase.impl.BuscarProdutoPorCategoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
@Api(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

  private final CadastrarProdutoUseCase cadastrarProduto;
  private final RemoverProdutoUseCase removerProduto;
  private final EditarProdutoUseCase editarProduto;

  @Autowired
  private BuscarProdutoPorCategoria buscarProdutoPorCategoria;

  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  @ApiImplicitParams({
          @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"),
          @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"),
          @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"),})
  @Operation(summary = "Criar produto.", description = "Cadastrar um produto no banco.")
  public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest){
    final ProdutoResponse produtoResponse = new ProdutoResponse(cadastrarProduto.execute(produtoRequest.toDomain()));
    return
        ResponseEntity.created(URI.create("/"+produtoResponse.getUuid()))
        .body(produtoResponse);
  }

  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 400, message = "Bad request"),
          @ApiResponse(code = 404, message = "Not found")
      }
  )
  @PutMapping(path = "/{id}")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "descricao", value = "Descrição do produto", required = true, dataType = "string", paramType = "body"),
          @ApiImplicitParam(name = "preco", value = "Preço do produto", required = true, dataType = "BigDecimal", paramType = "body"),
          @ApiImplicitParam(name = "categoria", value = "Categoria do produto", required = true, dataType = "string", paramType = "body"),})
  @Operation(summary = "Editar produtos.", description = "Editar um produto cadastrado baseado no uuid dele.")
  public ResponseEntity<Void> editarProduto(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest) {
    editarProduto.execute(UUID.fromString(id), produtoRequest.toDomain());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<ProdutoResponse>> buscarPorCategoria(@RequestParam String categoria) {
    return ResponseEntity.ok().body(buscarProdutoPorCategoria.execute(categoria));
  }

  @DeleteMapping(path = "/{produtoId}")
  @Operation(summary = "Remover produto.", description = "Remover um produto baseado no uuid dele.")
  public ResponseEntity<Void> removerProduto(@PathVariable String produtoId){
    removerProduto.execute(UUID.fromString(produtoId));
    return ResponseEntity.ok().build();
  }

}
