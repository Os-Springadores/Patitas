package br.com.ada.patitas.controller;

import static br.com.ada.patitas.DataConsulta.listaDeConsultas;
import static br.com.ada.patitas.DataHorariosDisponiveis.listaHorariosDisponiveis;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.service.HorariosDisponiveisService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@AutoConfigureMockMvc
@WebMvcTest(HorariosDisponiveisController.class)
public class HorariosDisponiveisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HorariosDisponiveisService horariosDisponiveisService;

    @InjectMocks
    private HorariosDisponiveisController horariosDisponiveisController;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void deveListarHorariosDisponiveis() throws Exception {
        List<HorariosDisponiveis> horariosDisponiveis = listaHorariosDisponiveis();
        when(horariosDisponiveisService.findAll()).thenReturn(horariosDisponiveis);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/horariosDisponiveis"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<HorariosDisponiveisDto> horariosDisponiveisDtos = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, HorariosDisponiveisDto.class));
        assertEquals(horariosDisponiveisDtos.size(), horariosDisponiveis.size());

    }

    @Test
    public void deveCadastrarHorarioDisponivel() throws Exception {
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();

        String requestBody = objectMapper.writeValueAsString(horariosDisponiveis);

        mockMvc.perform(MockMvcRequestBuilders.post("/horariosDisponiveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }
}