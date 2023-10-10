package eleitor.api.controller;

import eleitor.api.service.EleitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/eleitores")
public class EleitorController {

    private EleitorService eleitorService;

    public EleitorController(EleitorService eleitorService) {
        this.eleitorService = eleitorService;
    }

    /* ponto de entrada da aplicação, que verifica se uma pessoa tem
    voto obrigatório, opcional ou proibído */
    @GetMapping("/{idade}/{isAlfabetizado}")
    public ResponseEntity<String> verificarVoto(@PathVariable("idade") int idadePessoa,
                                                @PathVariable("isAlfabetizado") boolean isAlfabetizado) {
        String retornoSobreVoto = eleitorService.verificarVoto(idadePessoa, isAlfabetizado);
        return ResponseEntity.ok(retornoSobreVoto);
    }

}
