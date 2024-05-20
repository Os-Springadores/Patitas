//package br.com.ada.patitas.controller;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.List;
//
//import br.com.ada.patitas.DataHorariosDisponiveis;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import br.com.ada.patitas.dto.HorariosDisponiveisDto;
//import br.com.ada.patitas.model.HorariosDisponiveis;
//import br.com.ada.patitas.service.HorariosDisponiveisService;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class HorariosDisponiveisControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private HorariosDisponiveisService horariosDisponiveisService;
//
//    @InjectMocks
//    private HorariosDisponiveisController horariosDisponiveisController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void deveListarTodosHorarios() throws Exception {
//        List<HorariosDisponiveis> horariosDisponiveis = DataHorariosDisponiveis.listaHorariosDisponiveis();
//
//        when(horariosDisponiveisService.findAll()).thenReturn(horariosDisponiveis);
//
//        mockMvc.perform(get("/horariosDisponiveis"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        HorariosDisponiveisDto horariosDisponiveisDto = new HorariosDisponiveisDto();
//
//        mockMvc.perform(post("/horariosDisponiveis")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{}"))
//                .andExpect(status().isCreated());
//    }
//}