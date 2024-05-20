package br.com.ada.patitas.controller;


import br.com.ada.patitas.DataConsulta;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testaListaDeConsultas() throws Exception {
        List<Consulta> consultas = DataConsulta.listaDeConsultas();
        String consultasJson = mapper.writeValueAsString(consultas);
        when(consultaService.findAll()).thenReturn(consultas);

        mockMvc.perform(get("/consulta"))
                .andExpect(status().isOk())
                .andExpect(content().json(consultasJson));

    }

    @Test
    void deveRetornarNaoEncontradoSeConsultaNaoExiste() throws Exception {
        mockMvc.perform(get("/consulta/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deveEncontrarConsultaPorId() throws Exception {
        Consulta consulta = DataConsulta.consulta();
        String consultaJson = mapper.writeValueAsString(consulta);
        when(consultaService.findById(1l)).thenReturn(Optional.of(consulta));

        mockMvc.perform(get("/consulta/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(consultaJson));
    }

    @Test
    public void deveInserirConsulta() throws Exception {
        Consulta consulta = DataConsulta.consulta();
        String consultaJson = mapper.writeValueAsString(consulta);

        mockMvc.perform(post("/consulta")
                .content(consultaJson)
                .contentType("application/json")
        )
                .andExpect(status().isCreated());

        verify(consultaService).save(any(Consulta.class));
    }

//    public static Stream<Arguments> gerarDadosInvalidosParaConsulta() {
//        return Stream.of(
//                arguments(
//                        new Consulta(1l, 1l,1l, 1l,null),
//                        "id",
//                        "must not be blank"
//                ),
//                arguments(
//                        new Consulta(2l, 2l,2l, 2l,null),
//                        "id",
//                        "must not be blank"
//                ),
//                arguments(
//                        new Consulta(3l, 3l,3l, 3l,null),
//                        "id",
//                        "must not be blank"
//                )
//        );
//    }

    @ParameterizedTest
    @MethodSource("gerarDadosInvalidosParaConsulta")
    void deveValidarConsultaAntesDeInserir(Consulta consulta, String atributo, String erroEsperado) throws Exception {
        String alunoJson = mapper.writeValueAsString(consulta);
        String path = "$." + atributo;

        mockMvc.perform(post("/consulta")
                .content(alunoJson)
                .contentType("application/json")
        )
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath(path).value(erroEsperado));

        verifyNoInteractions(consultaService);
    }

    @Test
    public void deveDeletarConsulta() throws Exception {
        mockMvc.perform(delete("/consulta/1"))
                .andExpect(status().isOk());

        verify(consultaService).delete(1l);
    }
}