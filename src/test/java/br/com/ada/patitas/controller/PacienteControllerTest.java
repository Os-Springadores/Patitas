package br.com.ada.patitas.controller;
<<<<<<< HEAD
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
=======
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.ada.patitas.controller.PacienteController;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.service.PacienteService;

@SpringBootTest
@AutoConfigureMockMvc
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

<<<<<<< HEAD
    @Autowired
    private ObjectMapper objectMapper;

=======
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
<<<<<<< HEAD
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
=======
    public void testFindAll() throws Exception {
     
        List<Paciente> pacientes = new ArrayList<>();
        when(pacienteService.findAll()).thenReturn(pacientes);

     
        mockMvc.perform(get("/paciente"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {
     
        Paciente paciente = new Paciente();
        when(pacienteService.findById(anyLong())).thenReturn(Optional.of(paciente));

       
        mockMvc.perform(get("/paciente/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSave() throws Exception {
    
        PacienteDto pacienteDto = new PacienteDto();

    
        mockMvc.perform(post("/paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
                .andExpect(status().isCreated());
    }

    @Test
<<<<<<< HEAD
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
=======
    public void testUpdate() throws Exception {
       
        PacienteDto pacienteDto = new PacienteDto();

       
        mockMvc.perform(put("/paciente/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    }

    @Test
    public void testDelete() throws Exception {
        
        mockMvc.perform(delete("/paciente/1"))
                .andExpect(status().isNoContent());
    }
}
