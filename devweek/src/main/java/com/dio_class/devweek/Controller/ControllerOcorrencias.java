package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.FaixaEtaria;
import com.dio_class.devweek.Entity.Incidencia;
import com.dio_class.devweek.Repo.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerOcorrencias {

    private final IncidenciaRepo ocRepository;

    public ControllerOcorrencias(IncidenciaRepo ocRepository) {
        this.ocRepository = ocRepository;
    }

//    @GetMapping("/ocorrencias")
//    public ResponseEntity<List<Incidencia>> findOcorrencias(){
//        List<Incidencia> listaOcorrencia = ocRepository.findAll();
//        if (listaOcorrencia.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
//    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<?> findAllOcorrencias(){
        try {
            List<Incidencia> listaOcorrencia = ocRepository.findAll();
            return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @GetMapping("/faixaetaria")
//    public ResponseEntity<?> findAllFaixaEtaria(){
//        try{
//            List<FaixaEtaria> lista = fRepository.findAll();
//            return new ResponseEntity<>(lista, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id){
        Optional<Incidencia> ocorrenciaOptional = ocRepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            Incidencia ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(Incidencia newIncidencia){
        return ocRepository.save(newIncidencia);
    }
}
