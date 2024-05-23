package br.com.ada.patitas.controller;
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
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
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
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
       
        PacienteDto pacienteDto = new PacienteDto();

       
        mockMvc.perform(put("/paciente/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        
        mockMvc.perform(delete("/paciente/1"))
                .andExpect(status().isNoContent());
    }
}
