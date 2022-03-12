package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Regiao;
import com.dio_class.devweek.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Anotation para definir uma estrutura para RestAPI
@RestController
@RequestMapping("/api") //Anotation usada para mapear solicitações da Web para métodos do Spring Controller.
public class ControllerRegiao {
    //RegiaoRepo é uma interface do tipo JpaRepository (através da herança)
    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    //Anotation para requisição Get - retorna todos os registros findALL
    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return repository.findAll();
    }

    //Anotation para requisição Get - retorna um registro com base no ID
    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) { //A "<?>" simboliza a abstração do tipo (genérico)
        //Classe implementada a partir do Java8 para evitar nullPointerException
        Optional regiaoEscolhidaOptional = repository.findById(id);
        //Se estiverem presentes registros no repositório
        if (regiaoEscolhidaOptional.isPresent()) {
            //Objeto genérico
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            //ResponseEntity pertence ao SpringFramework serve para manipular a resposta da requisição
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Anotation para inserir um registro via requisição Post
    @PostMapping("/regiao/novo")
    public Regiao newFaixaHertária(@RequestBody Regiao newRegiao){//Anotation que mapeia o corpo HttpRequest para um Obj Java

        return repository.save(newRegiao);

    }

    @DeleteMapping("regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){//PathVariable defini como parâmetros de método.
        repository.deleteById(id);
    }

}
