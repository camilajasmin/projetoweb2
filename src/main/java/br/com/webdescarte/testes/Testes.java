package br.com.webdescarte.testes;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.webdescarte.dao.DAOusuario;
import br.com.webdescarte.dominio.Usuario;

public class Testes {



	// Vamos realizar os testes em todos os métodos que estão
	// classe DAOUsuario.

	// Vamos começar testando o cadastro do usuário
//	@Test
//	public void testCadastroUsuario() {
//		//realizar a instância da classe Usuario e aplicar dados
//		//ficticios para cadastrar. Esta técnica é chamada de dados
//		//mockados
//		Usuario us = new Usuario();
//		us.setNomeusuario("Camila");
//		us.setSenhausuario("12345");
//		us.setEmailusuario("camilinhaa@hotmail.com.br");
//		us.setTelefoneusuario("11-7655-5855");
//		us.setNomecompletousuario("Camila Jasmin");
//		us.setCpfusuario("5554334567");
//		us.setCnpjusuario("564555555/50555");
//		
//		//instância da classe  DAOUsuario
//		DAOusuario daous = new DAOusuario();
//		assertEquals("O cadastro foi realizado com sucesso!", daous.cadastrar(us));	
//	}
//}
	@Test
	public void testListar() {
	    // Preparar os dados esperados
	    List<Usuario> resultadoEsperado = new ArrayList<Usuario>();
	    // Adicionar alguns usuários à lista resultadoEsperado

	    // Chamar o método listar()
	    DAOusuario daous = new DAOusuario();
	    List<Usuario> resultadoReal = daous.listar();

	    // Comparar as listas
	    assertEquals(resultadoEsperado, resultadoReal);
	}}
//	@Test
//public void testPesquisar() {
//	DAOUsuario daous = new DAOUsuario();
//	Usuario us = new Usuario();
//	Usuario usuario_id = new Usuario();
//	
//	usuario_id.setIdusuario(1);
//	
//	assertEquals("pedro", daous.pesquisar(usuario_id).getNomeusuario());
//	
//}
//	@Test
//	public void testAtualizar() {
//		Usuario us_test = new Usuario();
//		us_test.setIdusuario(1);
//		us_test.setNomeusuario("pedro.pedreira");
//		us_test.setEmail("pp@outlook.com");
//		us_test.setTelefone("(11) 5689-9658");
//		us_test.setNomecompleto("Pedro Pedreira Nascimento");
//		
//		DAOUsuario daous = new DAOUsuario();
//		
//		assertEquals("Atualização realizada", daous.atualizar(us_test));
//		
//	}	
	
	
//	@Test
//	public void testLogin() {
//		Usuario us = new Usuario();
//		us.setNomeusuario("pedro.pedreira");
//		us.setSenha("123");
//		
//		DAOUsuario daous = new DAOUsuario();
//		assertTrue(daous.login(us)); 
//	}
	
	
//	@Test
//	public void testAlterarSenha() {
//		Usuario us = new Usuario();
//		us.setSenha("abc123");
//		us.setIdusuario(1);
//		DAOUsuario daous = new DAOUsuario();
//		assertEquals("Atualização realizada", daous.alterarSenha(us));
//	}
//}











