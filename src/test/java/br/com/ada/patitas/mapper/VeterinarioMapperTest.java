package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.model.Veterinario;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
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
=======
public class VeterinarioMapperTest {

    @Test
    public void testToDtoVeterinario() {

        Veterinario veterinario1 = new Veterinario("Dr. Carlos", "Cardiologia");
        Veterinario veterinario2 = new Veterinario("Dra. Maria", "Dermatologia");
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        List<Veterinario> veterinarios = new ArrayList<>();
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);

<<<<<<< HEAD
        List<VeterinarioDto> veterinarioDtos = VeterinarioMapper.toDtoVeterinario(veterinarios);

        assertEquals(2, veterinarioDtos.size());
        assertEquals("Dr. Israel", veterinarioDtos.get(0).getNome());
        assertEquals(Especialidade.CIRURGIA_GERAL, veterinarioDtos.get(0).getEspecialidade());
        assertEquals("Dra. Maria Heloisa", veterinarioDtos.get(1).getNome());
        assertEquals(Especialidade.DERMATOLOGIA, veterinarioDtos.get(1).getEspecialidade());
    }

    @Test
    public void testaToDtoVeterinarioDto() {
        Veterinario veterinario = new Veterinario(1l,"Dr. Israel", Especialidade.CIRURGIA_GERAL);

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
=======

        List<VeterinarioDto> veterinarioDtos = VeterinarioMapper.toDtoVeterinario(veterinarios);

  
        assertEquals(2, veterinarioDtos.size());
        assertEquals("Dr. Carlos", veterinarioDtos.get(0).getNome());
        assertEquals("Cardiologia", veterinarioDtos.get(0).getEspecialidade());
        assertEquals("Dra. Maria", veterinarioDtos.get(1).getNome());
        assertEquals("Dermatologia", veterinarioDtos.get(1).getEspecialidade());
    }

    @Test
    public void testToDtoVeterinarioDto() {

        Veterinario veterinario = new Veterinario("Dr. Carlos", "Cardiologia");


        VeterinarioDto veterinarioDto = VeterinarioMapper.toDtoVeterinarioDto(veterinario);


        assertNotNull(veterinarioDto);
        assertEquals("Dr. Carlos", veterinarioDto.getNome());
        assertEquals("Cardiologia", veterinarioDto.getEspecialidade());
    }

    @Test
    public void testToEntityVeterinario() {
   
        VeterinarioDto veterinarioDto = new VeterinarioDto("Dr. Carlos", "Cardiologia");

        Veterinario veterinario = VeterinarioMapper.toEntityVeterinario(veterinarioDto);

 
        assertNotNull(veterinario);
        assertEquals("Dr. Carlos", veterinario.getNome());
        assertEquals("Cardiologia", veterinario.getEspecialidade());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    }
}
