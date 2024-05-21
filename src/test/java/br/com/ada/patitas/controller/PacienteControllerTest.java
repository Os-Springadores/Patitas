package br.com.ada.patitas.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Especie;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PacienteController.class)
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
        Paciente paciente = new Paciente();
        paciente.getId();
        when(pacienteService.findById(1L)).thenReturn(Optional.of(paciente));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Paciente pacienteResponse = objectMapper.readValue(result.getResponse().getContentAsString(),
                Paciente.class);
        assertEquals(paciente.getId(), pacienteResponse);
    }

    @Test
    public void deveCadastrarUmPaciente() throws Exception {
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.getNome();
        pacienteDto.getEspecie();
        pacienteDto.getRaca();
        pacienteDto.getIdade();
        pacienteDto.getPeso();

        String requestBody = objectMapper.writeValueAsString(pacienteDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveAtualizarUmPaciente() throws Exception {
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setNome("Meliodas");
        pacienteDto.setEspecie(Especie.MAMIFERO);
        pacienteDto.setRaca("crocodilo");
        pacienteDto.setIdade(12);
        pacienteDto.setPeso(400);

        String requestBody = objectMapper.writeValueAsString(pacienteDto);

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
    }
}