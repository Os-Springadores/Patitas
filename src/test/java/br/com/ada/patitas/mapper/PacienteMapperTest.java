package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ada.patitas.model.Especie;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;
import java.util.ArrayList;
import java.util.List;



public class PacienteMapperTest {

    @Test
    public void testaToDtoPaciente() {
        Paciente paciente1 = new Paciente(1l, "lolo", Especie.MAMIFERO, "viralata", 5, 25.5);
        Paciente paciente2 = new Paciente(2l, "Napoleao", Especie.AVE, "Persa", 3, 3.8);

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(paciente1);
        pacientes.add(paciente2);

        List<PacienteDto> pacienteDtos = PacienteMapper.toDtoPaciente(pacientes);

        assertEquals(2, pacienteDtos.size());
        assertEquals("lolo", pacienteDtos.get(0).getNome());
        assertEquals(Especie.MAMIFERO, pacienteDtos.get(0).getEspecie());
        assertEquals("viralata", pacienteDtos.get(0).getRaca());
        assertEquals(5, pacienteDtos.get(0).getIdade());
        assertEquals(25.5, pacienteDtos.get(0).getPeso());
        assertEquals(2, pacienteDtos.size());
        assertEquals("Napoleao", pacienteDtos.get(1).getNome());
        assertEquals(Especie.AVE, pacienteDtos.get(1).getEspecie());

    }

    @Test
    public void testaToDtoPacienteDto() {
        Paciente paciente = new Paciente(1l, "lolo", Especie.MAMIFERO, "viralata", 5, 25.5);

        PacienteDto pacienteDto = PacienteMapper.toDtoPaciente(paciente);

        assertNotNull(pacienteDto);
        assertEquals("lolo", pacienteDto.getNome());
        assertEquals(Especie.MAMIFERO, pacienteDto.getEspecie());
        assertEquals("viralata", pacienteDto.getRaca());
 assertEquals(5, pacienteDto.getIdade());
        assertEquals(25.5, pacienteDto.getPeso());
    }

    @Test
    public void testaToEntityPaciente() {
        PacienteDto pacienteDto = new PacienteDto("lolo", Especie.MAMIFERO, "viralata", 5, 25.5);

        Paciente paciente = PacienteMapper.toEntityPaciente(pacienteDto);

        assertNotNull(paciente);
        assertEquals("lolo", paciente.getNome());
        assertEquals(Especie.MAMIFERO, paciente.getEspecie());
        assertEquals("viralata", paciente.getRaca());
        assertEquals(5, paciente.getIdade());
        assertEquals(25.5, paciente.getPeso());
    }
}
