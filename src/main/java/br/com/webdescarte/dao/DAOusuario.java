package br.com.webdescarte.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webdescarte.dominio.Usuario;

public class DAOusuario extends Conexao implements CRUDusuario<Usuario>{

	@Override
	public String cadastrar(Usuario dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String SQL = "insert into Usuario(nomeusuario,senhausuario,emailusuario,telefoneusuario,nomecompletousuario,cpfusuario,cnpjusuario)values(?,?,?,?,?,?,?)";

				pst = con.prepareStatement(SQL);
				
				pst.setString(1, dados.getNomeusuario());
				pst.setString(2, dados.getSenhausuario());
				pst.setString(3, dados.getEmailusuario());
				pst.setString(4, dados.getTelefoneusuario());
				pst.setString(5, dados.getNomecompletousuario());
				pst.setString(6, dados.getCpfusuario());
				pst.setString(7, dados.getCnpjusuario());
				
				if(pst.executeUpdate() > 0 ) {
					msg = "O cadastro foi realizado com sucesso!";
					}
				else {
					msg = "Não foi possível realizar o cadastro.";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados.";
			}
		} 
		catch (SQLException se) {
			msg = "Erro no cadastro" + se.getMessage();
		}
		catch (Exception e) {
			msg = "Erro Inesperado" + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			if(abrirConexao()) {
				String SQL = "select * from Usuario";
				pst = con.prepareStatement(SQL);
				rs = pst.executeQuery();
				while(rs.next()) {
					Usuario us = new Usuario();
					us.setIdusuario(rs.getInt(0));
					us.setNomeusuario(rs.getString(1));
					us.setSenhausuario(rs.getString(2));
					us.setEmailusuario(rs.getString(3));
					us.setTelefoneusuario(rs.getString(4));
					us.setNomecompletousuario(rs.getString(5));
					us.setCpfusuario(rs.getString(6));
					us.setCnpjusuario(rs.getString(7));
					
					lista.add(us);
				}
			}
			else {
				throw new Exception("Não foi possível estabelecer a conexão com o banco");
				
			}
			
		} 
		catch(SQLException se) {
			new Exception("Erro na consulta" + se.getMessage());
		}
		catch (Exception e) {
			new Exception("Erro inesperado" + e.getMessage());
		}
		finally {
			fecharConexao();
		}
				
		
		return lista;
	}

	@Override
	public String atualizar(Usuario dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String SQL = "update Usuario set nomeusuario=?, emailusuario = ?, telefoneusuario = ?, nomecompletousuario = ? where idusuario = ?";
				pst = con.prepareStatement(SQL);
				pst.setString(1, dados.getNomeusuario());
				pst.setString(2, dados.getEmailusuario());
				pst.setString(3, dados.getTelefoneusuario());
				pst.setString(4, dados.getNomecompletousuario());
				pst.setInt(5, dados.getIdusuario());
				
				if(pst.executeUpdate() > 0) {
					msg = "Atualização realizada";
				}
				else {
					msg = "Não foi possível atualizar";
				}
				
			} 
			
			else {
			    msg = "Não foi possível estabelecer a conexão com o banco";
			}
		} 
		catch(SQLException se) {
			msg = "Erro ao atualizar. " + se.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado" + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	@Override
	public boolean login(Usuario dados) {
		boolean auth = true;
		try {
			if (abrirConexao()) {
				String SQL = "select nomeusuario, senhausuario, emailusuario, cpfusuario, cnpjusuario from Usuario where nomeusuario=? or emailusuario=? or cpfusuario=? or cnpjusuario=? and senhausuario=?";
				pst = con.prepareStatement(SQL);
				
				pst.setString(1, dados.getNomeusuario());
				pst.setString(2, dados.getSenhausuario());
				pst.setString(3, dados.getEmailusuario());
				pst.setString(4, dados.getCpfusuario());
				pst.setString(5, dados.getCnpjusuario());
				
				rs = pst.executeQuery();
				
				if(!rs.next()) {
					auth=false;
				}
			} else {
				throw new Exception("Não foi possível estabelecer a conexão com o banco");
				

			}
			
		}
		catch (SQLException se ) {
			auth = false;
			new Exception("Erro na conculta" + se.getMessage());
			}
		catch (Exception e) {
			auth = false;
			new Exception("Erro Inesperado" + e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return auth;
	}

	@Override
	public String alterarSenha(Usuario dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "update Usuario set senhausuario=? where idusuario=?";
				
				pst = con.prepareStatement(sql);
	
				pst.setString(1,dados.getSenhausuario());
				pst.setInt(2, dados.getIdusuario());
				

				if(pst.executeUpdate() > 0) {
					msg = "Atualização realizada";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao atualizar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	@Override
	public String apagar(Integer id) {
		String msg = "";
		try {
			if (abrirConexao()) {
				String SQL = "delete from Usuario where idusuario = ?";
				pst = con.prepareStatement(SQL);
				pst.setInt(1, id);
				
				if (pst.executeUpdate() > 0) {
					msg = "Usuário apagado";
				} else {
					msg = "Não foi possível apagar";
				}
				
			} else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
			
		} catch(SQLException se) {
			msg = "Erro ao apagar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}}

	