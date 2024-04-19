package br.com.webdescarte.dominio;
public class Servico {
	private Integer idservico;
	private Integer idusuario;
	private String datahoraservico;
	private String orcamentoservico;
	
	public Integer getIdservico() {
		return idservico;
	}
	public void setIdservico(Integer idservico) {
		this.idservico = idservico;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getDatahoraservico() {
		return datahoraservico;
	}
	public void setDatahoraservico(String datahoraservico) {
		this.datahoraservico = datahoraservico;
	}
	public String getOrcamentoservico() {
		return orcamentoservico;
	}
	public void setOrcamentoservico(String orcamentoservico) {
		this.orcamentoservico = orcamentoservico;
	}
}