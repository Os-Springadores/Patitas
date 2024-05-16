package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.model.Veterinario;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioMapperTest {

    @Test
    public void testToDtoVeterinario() {
        // Given
        Veterinario veterinario1 = new Veterinario("Dr. Carlos", "Cardiologia");
        Veterinario veterinario2 = new Veterinario("Dra. Maria", "Dermatologia");
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);

        // When
        List<VeterinarioDto> veterinarioDtos = VeterinarioMapper.toDtoVeterinario(veterinarios);

        // Then
        assertEquals(2, veterinarioDtos.size());
        assertEquals("Dr. Carlos", veterinarioDtos.get(0).getNome());
        assertEquals("Cardiologia", veterinarioDtos.get(0).getEspecialidade());
        assertEquals("Dra. Maria", veterinarioDtos.get(1).getNome());
        assertEquals("Dermatologia", veterinarioDtos.get(1).getEspecialidade());
    }

    @Test
    public void testToDtoVeterinarioDto() {
        // Given
        Veterinario veterinario = new Veterinario("Dr. Carlos", "Cardiologia");

        // When
        VeterinarioDto veterinarioDto = VeterinarioMapper.toDtoVeterinarioDto(veterinario);

        // Then
        assertNotNull(veterinarioDto);
        assertEquals("Dr. Carlos", veterinarioDto.getNome());
        assertEquals("Cardiologia", veterinarioDto.getEspecialidade());
    }

    @Test
    public void testToEntityVeterinario() {
        // Given
        VeterinarioDto veterinarioDto = new VeterinarioDto("Dr. Carlos", "Cardiologia");

        // When
        Veterinario veterinario = VeterinarioMapper.toEntityVeterinario(veterinarioDto);

        // Then
        assertNotNull(veterinario);
        assertEquals("Dr. Carlos", veterinario.getNome());
        assertEquals("Cardiologia", veterinario.getEspecialidade());
    }
}
