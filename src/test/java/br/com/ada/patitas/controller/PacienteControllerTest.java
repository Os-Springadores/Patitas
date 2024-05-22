package br.com.ada.patitas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.ada.patitas.DataPaciente;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveListarPacientes() throws Exception {
        List<Paciente> pacientes = Arrays.asList(new Paciente(), new Paciente());
        when(pacienteService.findAll()).thenReturn(pacientes);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/paciente"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<PacienteDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, PacienteDto.class));
        assertEquals(pacientes.size(), responseDto.size());
    }

    @Test
    public void deveEncontrarPacientePorId() throws Exception {

        Paciente paciente = DataPaciente.paciente();
        String pacienteJson = objectMapper.writeValueAsString(paciente);

        when(pacienteService.findById(1L)).thenReturn(Optional.of(paciente));
        mockMvc.perform(get("/paciente/1"))
                .andExpect(status().isOk());



    }

    @Test
    public void deveCadastrarUmPaciente() throws Exception {
        Paciente paciente = DataPaciente.paciente();

        String pacienteJson = objectMapper.writeValueAsString(paciente);

        mockMvc.perform(MockMvcRequestBuilders.post("/paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacienteJson))
                .andExpect(status().isCreated());
        verify(pacienteService).save(any(Paciente.class));
    }

    @Test
    public void deveAtualizarUmPaciente() throws Exception {
        Paciente paciente = DataPaciente.paciente();

        String requestBody = objectMapper.writeValueAsString(paciente);

        when(pacienteService.update(any(Long.class), any(Paciente.class)))
                .thenReturn(Optional.of(new Paciente()));

        mockMvc.perform(MockMvcRequestBuilders.put("/paciente/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarUmPaciente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/1"))
                .andExpect(status().isNoContent());
        verify(pacienteService).delete(1L);
    }
}
