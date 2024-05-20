package br.com.ada.patitas.integration;

import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static br.com.ada.patitas.DataConsulta.listaDeConsultas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrudApplicationIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ConsultaRepository consultaRepository;

    ObjectMapper mapper = new ObjectMapper();

    private String getUrl(String endpoint) {
        return String.format("http://localhost:%d%s", port, endpoint);
    }

    @AfterEach
    public void limparBanco() {
        consultaRepository.deleteAll();
    }

    @Test
    @Sql({"/consultas.sql"})
    public void deveListarConsultas() throws JsonProcessingException {
        String consultaJson = mapper.writeValueAsString(listaDeConsultas());

        ResponseEntity<String> resposta = restTemplate.getForEntity(
                getUrl("/consulta"),
                String.class
        );
    }

    @Test
    @Sql({"/consultas.sql"})
    public void deveEnviarRespostaVaziaQuandoNaoHaConsultas() throws Exception {
        String respostaVazia = "[]";

        ResponseEntity<String> resposta = restTemplate.getForEntity(
                getUrl("/consulta"),
                String.class
        );

        assertEquals(resposta.getStatusCode(), HttpStatus.OK);
        assertEquals(respostaVazia, resposta.getBody());
    }

    @Test
    public void deveInserirUmaConsulta() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(
                "{\"id\": \"1l\", \"id\": \"1l\",\"id\": \"1l\",\"id\": \"1l\",\"motivoDaConsulta\": \"Animal com febre\"}",
                headers
        );

        ResponseEntity<String> reposta = restTemplate.postForEntity(
                getUrl("/consulta"),
                request,
                String.class
        );
        assertEquals(reposta.getStatusCode(),HttpStatus.CREATED);
        Optional<Consulta> consultaOptional= consultaRepository.findById(1l);
        assertTrue(consultaOptional.isPresent());
        assertEquals(consultaOptional.get().getId(),1l);
        assertEquals(consultaOptional.get().getIdPaciente(),1l);
        assertEquals(consultaOptional.get().getIdVeterinario(),1l);
        assertEquals(consultaOptional.get().getIdHorariosDisponiveis(),1l);
        assertEquals(consultaOptional.get().getMotivoDaConsulta(),"Motivo da Consulta");

    }

    @Test
    @Sql({"/consultas.sql"})
    public void deveDeletarConsulta()throws Exception{
        restTemplate.delete(getUrl("/consulta/1"));

        Optional<Consulta>consultaOptional=consultaRepository.findById(1l);
        assertTrue(consultaOptional.isEmpty());

        List<Consulta> consultas = consultaRepository.findAll();
        assertEquals(2, Lists.newArrayList(consultas).size());
    }

}