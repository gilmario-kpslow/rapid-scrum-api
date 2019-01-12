package br.com.rapidscrum.rapidscrum.resources;

import br.com.rapidscrum.rapidscrum.domain.Sistema;
import br.com.rapidscrum.rapidscrum.util.JsonConverter;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author gilmario
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SistemaResourceTest {

    @Autowired
    private MockMvc mvc;
    
    private Long ultimoIdSalvo;
    
    @Before
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Sistema sistema = new Sistema();
        sistema.setDescricao("Sistema de Teste");
        sistema.setNome("TESTE SIST");
        sistema.setSigla("SIS");
        mvc.perform(MockMvcRequestBuilders.post("/sistemas")
                .content(new JsonConverter().toJson(sistema))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo((MvcResult mr) -> {
                    System.out.println(mr.getResponse().getContentAsString());
                    Sistema sistema1 = new JsonConverter().fromJson(mr.getResponse().getContentAsString(), Sistema.class);
                    ultimoIdSalvo = sistema1.getId();
                    Assert.assertNotNull(sistema1.getId());
        });
    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        mvc.perform(MockMvcRequestBuilders.get("/sistemas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo((MvcResult mr) -> {
                    System.out.println(mr.getResponse().getContentAsString());
                    List<Sistema> sistema1 = new JsonConverter().fromJsonList(mr.getResponse().getContentAsString(), Sistema.class);
                    Assert.assertTrue(sistema1.size() >0);
        });
    }
    
    /**
    *
    * @author gustavo
    */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = 1L;
        mvc.perform(MockMvcRequestBuilders.get("/sistemas/".concat(id.toString()))
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.status().isOk()).andDo((MvcResult mr) -> {
        			String response = mr.getResponse().getContentAsString();
        			System.out.println(response);
        			Sistema sistema1 = new JsonConverter().fromJson(response, Sistema.class);
        			Assert.assertNotNull(sistema1);
        		});
    }
    
    /**
    *
    * @author gustavo
    */
    @Test
    public void testUpdate() throws Exception {
    	System.out.println("update");
    	Sistema sistema = new Sistema();
    	sistema.setId(2L);
    	sistema.setNome("novoNome");
    	sistema.setDescricao("novaDescricao");
    	sistema.setSigla("NS");
    	mvc.perform(MockMvcRequestBuilders.put("/sistemas")
    			.content(new JsonConverter().toJson(sistema))
    			.contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isOk()).andDo((MvcResult mr) -> {
    				String response = mr.getResponse().getContentAsString();
    				System.out.println(response);
    				Sistema sistema1 = new JsonConverter().fromJson(response, Sistema.class);
    				Assert.assertNotNull(sistema1);
    				Assert.assertEquals(sistema.getId(), sistema1.getId());
    			});
    }
    
    /**
    *
    * @author gustavo
    */
    @Test
    public void testDeleteById() throws Exception {
    	System.out.println("deleteById");
    	Long id = ultimoIdSalvo;
    	
    	mvc.perform(MockMvcRequestBuilders.delete("/sistemas/".concat(id.toString()))
    			.contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo((MvcResult mr) -> {
    				String response = mr.getResponse().getContentAsString();
    				System.out.println(response);
    				Assert.assertEquals("", response);
    			});
    }
//
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        Long id = null;
//        SistemaResource instance = new SistemaResource();
//        ResponseEntity<Sistema> expResult = null;
//        ResponseEntity<Sistema> result = instance.findById(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Sistema sistema = null;
//        SistemaResource instance = new SistemaResource();
//        ResponseEntity<Sistema> expResult = null;
//        ResponseEntity<Sistema> result = instance.update(sistema);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testDeleteById() {
//        System.out.println("deleteById");
//        Long id = null;
//        SistemaResource instance = new SistemaResource();
//        ResponseEntity<Void> expResult = null;
//        ResponseEntity<Void> result = instance.deleteById(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
}
