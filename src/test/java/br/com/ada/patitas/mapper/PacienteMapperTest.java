package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteMapperTest {

    @Test
    public void testToDtoPaciente() {
        // Given
        Paciente paciente1 = new Paciente("Rex", "Cachorro", "Golden Retriever", 5, 25.5);
        Paciente paciente2 = new Paciente("Mimi", "Gato", "Persa", 3, 3.8);
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(paciente1);
        pacientes.add(paciente2);

        // When
        List<PacienteDto> pacienteDtos = PacienteMapper.toDtoPaciente(pacientes);

        // Then
        assertEquals(2, pacienteDtos.size());
        assertEquals("Rex", pacienteDtos.get(0).getNome());
        assertEquals("Cachorro", pacienteDtos.get(0).getEspecie());
        assertEquals("Golden Retriever", pacienteDtos.get(0).getRaca());
        assertEquals(5, pacienteDtos.get(0).getIdade());
        assertEquals(25.5, pacienteDtos.get(0).getPeso());
        assertEquals("Mimi", pacienteDtos.get(1).getNome());
        assertEquals("Gato", pacienteDtos.get(1).getEspecie());
        assertEquals("Persa", pacienteDtos.get(1).getRaca());
        assertEquals(3, pacienteDtos.get(1).getIdade());
        assertEquals(3.8, pacienteDtos.get(1).getPeso());
    }

    @Test
    public void testToDtoPacienteDto() {
        // Given
        Paciente paciente = new Paciente("Rex", "Cachorro", "Golden Retriever", 5, 25.5);

        // When
        PacienteDto pacienteDto = PacienteMapper.toDtoPaciente(paciente);

        // Then
        assertNotNull(pacienteDto);
        assertEquals("Rex", pacienteDto.getNome());
        assertEquals("Cachorro", pacienteDto.getEspecie());
        assertEquals("Golden Retriever", pacienteDto.getRaca());
        assertEquals(5, pacienteDto.getIdade());
        assertEquals(25.5, pacienteDto.getPeso());
    }

    @Test
    public void testToEntityPaciente() {
        // Given
        PacienteDto pacienteDto = new PacienteDto("Rex", "Cachorro", "Golden Retriever", 5, 25.5);

        // When
        Paciente paciente = PacienteMapper.toEntityPaciente(pacienteDto);

        // Then
        assertNotNull(paciente);
        assertEquals("Rex", paciente.getNome());
        assertEquals("Cachorro", paciente.getEspecie());
        assertEquals("Golden Retriever", paciente.getRaca());
        assertEquals(5, paciente.getIdade());
        assertEquals(25.5, paciente.getPeso());
    }
}
