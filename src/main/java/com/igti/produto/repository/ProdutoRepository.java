package com.igti.produto.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.igti.produto.entity.Produto;

/**
 * classe para manipular documentos do repositorio (integracao com mongodb)
 * 
 * @author Thais
 */
public interface ProdutoRepository extends MongoRepository<Produto, String> {
	List<Produto> findByNome(String nome);
}
