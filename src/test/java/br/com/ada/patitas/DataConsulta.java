package br.com.ada.patitas;

import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.Servico;

import java.util.List;

public class DataConsulta {
    public static List<Consulta> listaDeConsultas() {
        return List.of(
                 new Consulta(1l,null,null, null, Servico.CIRURGIA,"Castração",250.0,true),
                new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true),
                new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true));
    }

    public static Consulta consulta() {
        return  new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true);
    }
}