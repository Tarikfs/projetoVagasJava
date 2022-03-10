package com.tfs.projetoDemo.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tfs.projetoDemo.controller.dto.DetalhesDaVagaDto;
import com.tfs.projetoDemo.controller.dto.VagaDto;
import com.tfs.projetoDemo.controller.form.AtualizacaoVagaForm;
import com.tfs.projetoDemo.controller.form.VagaForm;
import com.tfs.projetoDemo.model.Vaga;
import com.tfs.projetoDemo.repository.CargoRepository;
import com.tfs.projetoDemo.repository.VagaRepository;

@RestController
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	private VagaRepository vagaRepository;

	private CargoRepository cargoRepository;

	@GetMapping
	@Cacheable(value = "listaDeVagas")
	public Page<VagaDto> lista(@RequestParam(required = false) String funcaoCargo,
			@PageableDefault(sort = "dataOrigem", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (funcaoCargo == null) {
			Page<Vaga> vaga = vagaRepository.findAll(paginacao);
			return VagaDto.converter(vaga);
		} else {
			Page<Vaga> vaga = vagaRepository.findByCargoFuncao(funcaoCargo, paginacao);
			return VagaDto.converter(vaga);
		}
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<VagaDto> cadastrar(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder) {
		Vaga vaga = form.converter(cargoRepository);
		vagaRepository.save(vaga);

		URI uri = uriBuilder.path("/vagas/{vagaID}").buildAndExpand(vaga.getVagaID()).toUri();
		return ResponseEntity.created(uri).body(new VagaDto(vaga));
	}

	@GetMapping("/{vagaID}")
	public ResponseEntity<DetalhesDaVagaDto> detalhar(@PathVariable Long vagaID) {
		Optional<Vaga> vaga = vagaRepository.findById(vagaID);
		if (vaga.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaVagaDto(vaga.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{vagaID}")
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<VagaDto> atualizar(@PathVariable Long vagaID, AtualizacaoVagaForm form) {
		Optional<Vaga> optional = vagaRepository.findById(vagaID);
		if (optional.isPresent()) {
			Vaga vaga = form.atualizar(vagaID, vagaRepository);
			return ResponseEntity.ok(new VagaDto(vaga));

		}

		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{vagaID}")
	@Transactional
	@CacheEvict(value = "listaDeVagas", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long vagaID) {
		Optional<Vaga> optional = vagaRepository.findById(vagaID);
		if (optional.isPresent()) {
			vagaRepository.deleteById(vagaID);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}