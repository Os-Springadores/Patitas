package br.com.ada.patitas.controller;

import br.com.ada.patitas.DataConsulta;
import br.com.ada.patitas.DataPaciente;
import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import br.com.ada.patitas.repository.VeterinarioRepository;
import br.com.ada.patitas.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static br.com.ada.patitas.DataConsulta.listaDeConsultas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
@WebMvcTest(ConsultaController.class)
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    @MockBean
    private HorariosDisponiveisRepository horariosDisponiveisRepository;

    @MockBean
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveListarTodasConsultas() throws Exception {
        List<Consulta> consultas = listaDeConsultas();
        when(consultaService.findAll()).thenReturn(consultas);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/consulta"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<ConsultaDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ConsultaDto.class));
        assertEquals(consultas.size(), responseDto.size());
    }

    @Test
    void deveRetornarNaoEncontradoSeConsultaNaoExiste() throws Exception {
        mockMvc.perform(get("/alunos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deveEncontrarConsultaPorId() throws Exception {
        Consulta consulta = DataConsulta.consulta();
        String consultaJson = objectMapper.writeValueAsString(consulta);

        when(consultaService.findById(1L)).thenReturn(Optional.of(consulta));
        mockMvc.perform(get("/consulta/1"))
                .andExpect(status().isOk());


    }


    @Test
    public void deveCadastrarUmaConsulta() throws Exception {

        Consulta consulta = DataConsulta.consulta();
        String consultaJson = objectMapper.writeValueAsString(consulta);
        mockMvc.perform(post("/consulta")
                .content(consultaJson)
                .contentType("application/json"))
                .andExpect(status().isCreated());
        verify(consultaService).save(any(Consulta.class));
    }


    @Test
    public void deveAtualizarUmaConsulta() throws Exception {
        Consulta consulta = DataConsulta.consulta();
        String requestBody = objectMapper.writeValueAsString(consulta);

        when(consultaService.update(any(Long.class), any(Consulta.class))).thenReturn(Optional.of(new Consulta()));

        mockMvc.perform(MockMvcRequestBuilders.put("/consulta/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarUmaConsulta() throws Exception {
        mockMvc.perform(delete("/consulta/1"))
                .andExpect(status().isNoContent());

        verify(consultaService).delete(1L);
    }


}