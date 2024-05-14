package br.com.ada.patitas.controller;

import br.com.ada.patitas.model.Especialidade;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.service.VeterinarioService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.com.ada.patitas.mapper.VeterinarioMapper.toDtoVeterinario;

import static br.com.ada.patitas.mapper.VeterinarioMapper.toDtoVeterinarioDto;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class VeterinarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeterinarioService veterinarioService;

    private final ObjectMapper mapper = new ObjectMapper();

    @InjectMocks
    private VeterinarioController veterinarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testBuscarTodosVeterinarios() throws Exception {

        List<Veterinario> veterinarios = new ArrayList<>();
        String veterinariosJson = mapper.writeValueAsString(toDtoVeterinario(veterinarios));
        when(veterinarioService.buscarTodosVeterinarios()).thenReturn(veterinarios);

        mockMvc.perform(get("/veterinario"))
                .andExpect(status().isOk())
                .andExpect(content().json(veterinariosJson));

    }

    @Test
    public void deveRetornarNaoEncontradosSeVeterinarioNaoExiste() throws Exception {
        mockMvc.perform(get("/veterinario/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testBuscarVeterinarioPorId() throws Exception {
        Veterinario veterinario = new Veterinario();
        String veterinarioJson = mapper.writeValueAsString(toDtoVeterinarioDto(veterinario));
        when(veterinarioService.buscarVeterinarioPorId(veterinario.getId())).thenReturn(Optional.of(veterinario));

        mockMvc.perform(get("/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is(veterinario.getNome())))
                .andExpect(jsonPath("$.especialidade", is(veterinario.getEspecialidade())))
                .andExpect(jsonPath("$.horariosDisponiveis", is(veterinario.getHorariosDisponiveis())));

    }

    @Test
    public void testCadastrarVeterinario() throws Exception {
        Veterinario veterinario = new Veterinario();
        when(veterinarioService.cadastrarVeterinario(veterinario)).thenReturn(veterinario);

        // ResponseEntity<Veterinario> response = veterinarioController.cadastrarVeterinario(veterinario);

        //  assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //  assertEquals(veterinario, response.getBody());
    }

    @ParameterizedTest
    @MethodSource("gerarDadosInvalidosParaVeterinarios")
    public void deveValidarVeterinariosAntesDeInserir(Veterinario veterinario, String atributo, String erroEsperado) throws Exception {
        String veterinarioJson = mapper.writeValueAsString(veterinario);
        String caminho = "$.errors." + atributo;

        mockMvc.perform(post("/veterinario")
                .content(veterinarioJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(caminho).value(erroEsperado));
    }

    public static Stream<Arguments> gerarDadosInvalidosParaVeterinarios() {
        return Stream.of(
                Arguments.of(
                        new Veterinario(1l, "Israel", Especialidade.CARDIOLOGIA, Collections.singletonList("16:00")),
                        "nome",
                        "Erro esperado para o campo nome"
                ),
                Arguments.of(
                        new Veterinario(2l, "Jhenny", Especialidade.DERMATOLOGIA, Collections.singletonList("6:00")),
                        "especialidade",
                        "Erro esperado para o campo especialidade"
                ),
                Arguments.of(
                        new Veterinario(3l, "Gabriel", Especialidade.ENDOCRINOLOGIA, Collections.singletonList("12:00")),
                        "horariosDisponiveis",
                        "Erro esperado para o campo horariosDisponiveis"
                )
        );
    }

    @Test
    public void testDeletarVeterinario() throws Exception {
        mockMvc.perform(delete("/veterinario/1"))
                .andExpect(status().isNoContent());
        verify(veterinarioService).deletarVeterinario(1l);
    }
}