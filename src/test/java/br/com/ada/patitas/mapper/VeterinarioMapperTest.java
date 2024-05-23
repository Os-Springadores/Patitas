package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ada.patitas.model.Especialidade;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.model.Veterinario;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioMapperTest {

    @Test
    public void testaToDtoVeterinario() {
        Veterinario veterinario1 = new Veterinario(1l,"Dr. Israel", Especialidade.CIRURGIA_GERAL);
        Veterinario veterinario2 = new Veterinario(2l,"Dra. Maria Heloisa", Especialidade.DERMATOLOGIA);
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);

        List<VeterinarioDto> veterinarioDtos = VeterinarioMapper.toDtoVeterinario(veterinarios);

        assertEquals(2, veterinarioDtos.size());
        assertEquals("Dr. Israel", veterinarioDtos.get(0).getNome());
        assertEquals(Especialidade.CIRURGIA_GERAL, veterinarioDtos.get(0).getEspecialidade());
        assertEquals("Dra. Maria Heloisa", veterinarioDtos.get(1).getNome());
        assertEquals(Especialidade.DERMATOLOGIA, veterinarioDtos.get(1).getEspecialidade());
    }

    @Test
    public void testaToDtoVeterinarioDto() {
        Veterinario veterinario = new Veterinario(1l,"Dr. Israel",Especialidade.CIRURGIA_GERAL);

        VeterinarioDto veterinarioDto = VeterinarioMapper.toDtoVeterinario(veterinario);

        assertNotNull(veterinarioDto);
        assertEquals("Dr. Israel", veterinarioDto.getNome());
        assertEquals(Especialidade.CIRURGIA_GERAL, veterinarioDto.getEspecialidade());
    }

    @Test
    public void testaToEntityVeterinario() {
        VeterinarioDto veterinarioDto = new VeterinarioDto("Dr. Israel", Especialidade.CIRURGIA_GERAL);

        Veterinario veterinario = VeterinarioMapper.toEntityVeterinario(veterinarioDto);

        assertNotNull(veterinario);
        assertEquals("Dr. Israel", veterinario.getNome());
        assertEquals(Especialidade.CIRURGIA_GERAL, veterinario.getEspecialidade());
    }
}