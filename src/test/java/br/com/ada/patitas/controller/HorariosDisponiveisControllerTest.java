package br.com.ada.patitas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.service.HorariosDisponiveisService;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveListarHorariosDisponiveis() throws Exception {
        List<HorariosDisponiveis> horariosDisponiveis = Arrays.asList(new HorariosDisponiveis(), new HorariosDisponiveis());
        when(horariosDisponiveisService.findAll()).thenReturn(horariosDisponiveis);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/horariosDisponiveis"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<HorariosDisponiveisDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, HorariosDisponiveisDto.class));
        assertEquals(horariosDisponiveis.size(), responseDto.size());
    }

    @Test
    public void deveCadastrarHorarioDisponivel() throws Exception {
        HorariosDisponiveisDto horariosDisponiveisDto = new HorariosDisponiveisDto();

        String requestBody = objectMapper.writeValueAsString(horariosDisponiveisDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/horariosDisponiveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }
}