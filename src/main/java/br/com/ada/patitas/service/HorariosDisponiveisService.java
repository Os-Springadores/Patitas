package br.com.ada.patitas.service;

import br.com.ada.patitas.model.HorariosDisponiveis;

import java.util.List;

public interface HorariosDisponiveisService {

    List<HorariosDisponiveis> findAll();

    HorariosDisponiveis save(HorariosDisponiveis horariosDisponiveis);
}
