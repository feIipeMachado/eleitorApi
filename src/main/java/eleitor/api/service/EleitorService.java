package eleitor.api.service;

import org.springframework.stereotype.Service;

@Service
public class EleitorService {

    public String verificarVoto(int idadePessoa, boolean isAlfabetizado){
       if (isAlfabetizado) {
            return verificarVotoDeEleitorAlfabetizado(idadePessoa);
       } else {
           return verificarVotoDeEleitorNaoAlfabetizado(idadePessoa);
       }
    }

    private String verificarVotoDeEleitorNaoAlfabetizado(int idadePessoa) {
        if (idadePessoa >= 16) {
            return "Voto Opcional";
        } else {
            return "Voto proibído";
        }
    }

    private String verificarVotoDeEleitorAlfabetizado(int idadePessoa) {
        if ((idadePessoa >= 16 && idadePessoa < 18) || idadePessoa > 70) {
            return "Voto Opcional";
        } else if (idadePessoa >= 18 && idadePessoa < 70) {
            return "Voto Obrigatorio";
        } else {
            return "Voto Proibido";
        }
    }


}
