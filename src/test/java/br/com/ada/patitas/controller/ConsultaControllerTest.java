package br.com.ada.patitas.controller;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import br.com.ada.patitas.repository.VeterinarioRepository;
import br.com.ada.patitas.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @InjectMocks
    private ConsultaController consultaController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveListarTodasConsultas() throws Exception {
        List<Consulta> consultas = Arrays.asList(new Consulta(), new Consulta());
        when(consultaService.findAll()).thenReturn(consultas);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/consulta"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<ConsultaDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ConsultaDto.class));
        assertEquals(consultas.size(), responseDto.size());
    }

    @Test
    public void deveEncontrarConsultaPorId() throws Exception {


        Consulta consulta1 = new Consulta();
        Consulta consulta2 = new Consulta();
        List<Consulta> consultas = Arrays.asList(consulta1, consulta2);


        when(consultaService.findAll()).thenReturn(consultas);


        ResponseEntity<List<ConsultaDto>> response = consultaController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }


    @Test
    public void deveCadastrarUmaConsulta() throws Exception {
        when(horariosDisponiveisRepository.findById(any(Long.class))).thenReturn(Optional.of(new HorariosDisponiveis()));
        when(veterinarioRepository.findById(any(Long.class))).thenReturn(Optional.of(new Veterinario()));

        ConsultaDto consultaDto = new ConsultaDto();

        String requestBody = objectMapper.writeValueAsString(consultaDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/consulta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveAtualizarUmaConsulta() throws Exception {
        Consulta consulta = new Consulta();
        String requestBody = objectMapper.writeValueAsString(consulta);

        when(consultaService.update(any(Long.class), any(Consulta.class))).thenReturn(Optional.of(new Consulta()));

        mockMvc.perform(MockMvcRequestBuilders.put("/consulta/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarUmaConsulta() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/consulta/1"))
                .andExpect(status().isNoContent());
    }


}