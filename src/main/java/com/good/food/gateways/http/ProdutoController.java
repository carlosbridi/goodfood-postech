package com.good.food.gateways.http;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.gateways.http.request.ProdutoRequest;
import com.good.food.gateways.http.response.ProdutoResponse;
import com.good.food.usecase.BuscarProdutoPorCategoria;
import com.good.food.usecase.CadastrarProduto;
import com.good.food.usecase.RemoverProduto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
@Api(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
  
  @Autowired
  private CadastrarProduto cadastrarProduto;
  
  @Autowired 
  private RemoverProduto removerProduto;
  
  @Autowired 
  private BuscarProdutoPorCategoria buscarProdutoPorCategoria;
  
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/cadastro")
  public ResponseEntity<ProdutoResponse> cadastrarCliente(@RequestBody ProdutoRequest produtoRequest){
    final ProdutoResponse produtoResponse = new ProdutoResponse(cadastrarProduto.execute(produtoRequest.toDomain()));
    return 
        ResponseEntity.created(URI.create("/"+produtoResponse.getUuid()))
        .body(produtoResponse);
  }


  @PutMapping(path = "/editar/{id}")  
  public ResponseEntity<Void> editarProduto(@PathVariable String produtoId, @RequestBody ProdutoRequest produtoRequest){
    
    return null;
  }

  @GetMapping(path = "buscarPorCategoria")
  public ResponseEntity<List<ProdutoResponse>> buscarPorCategoria(@RequestBody EProdutoCategoria categoria ){
    return ResponseEntity.ok().body(buscarProdutoPorCategoria.execute(categoria));
  }
  
  @DeleteMapping(path = "/{produtoId}")
  public ResponseEntity<Void> removerProduto(@PathVariable String produtoId){
    removerProduto.execute(UUID.fromString(produtoId));
    return ResponseEntity.ok().build();
  }
  
}
