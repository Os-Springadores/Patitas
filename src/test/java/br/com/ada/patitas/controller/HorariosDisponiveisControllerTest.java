package br.com.ada.patitas.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import br.com.ada.patitas.controller.HorariosDisponiveisController;
import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.service.HorariosDisponiveisService;

@SpringBootTest
@AutoConfigureMockMvc
public class HorariosDisponiveisControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HorariosDisponiveisService horariosDisponiveisService;

    @InjectMocks
    private HorariosDisponiveisController horariosDisponiveisController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
<<<<<<< HEAD
    public void deveListarHorariosDisponiveis() throws Exception {
        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        when(horariosDisponiveisService.findAll()).thenReturn(horariosDisponiveis);

=======
    public void testFindAll() throws Exception {
        
        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        when(horariosDisponiveisService.findAll()).thenReturn(horariosDisponiveis);

        
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        mockMvc.perform(get("/horariosDisponiveis"))
                .andExpect(status().isOk());
    }

    @Test
<<<<<<< HEAD
    public void deveCadastrarUmHorarioDisponivel() throws Exception {
=======
    public void testSave() throws Exception {
     
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        HorariosDisponiveisDto horariosDisponiveisDto = new HorariosDisponiveisDto();
        horariosDisponiveisDto.getHorariosDisponiveis();

        String requestBody = objectMapper.writeValueAsString(horariosDisponiveisDto);

<<<<<<< HEAD
=======
    
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        mockMvc.perform(post("/horariosDisponiveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }
}
