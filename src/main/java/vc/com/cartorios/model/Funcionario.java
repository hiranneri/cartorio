package vc.com.cartorios.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="tb_funcionario")
public class Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="incr")
	@GenericGenerator(name="incr", strategy="increment")
	private Long id;
	
	@Column(name="nm_nome", nullable=false, length=255)
	private String nome;
	
	@Column(name="ds_senha", nullable=false, length=255)
	private String senha;
	
	@Column(name="ds_cpf", nullable=false, length=255)
	private String cpf;
	
	@Column(name="dt_admissao", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@Column(name="dt_demissao", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataDemissao;
	
	@Column(name="ds_salario", nullable=false, precision=8, scale=2)
	private BigDecimal salario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public int hashCode(){
		final int prime=31;
		int result =1;
		result = prime*((id==null)? 0:id.hashCode());
		return result;
	}
	public boolean equals(Object objeto){
		if(this==objeto)
			return true;
		if(objeto==null)
			return false;
		if(getClass()!=objeto.getClass())
			return false;
		final Funcionario funcionario = (Funcionario)objeto;
		if(id==null){
			if(funcionario.id !=null)
				return false;
		}else if(!id.equals(funcionario.id))
			return false;
		return true;
	}
	
	@Transient
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
	public boolean compararUsuario(Funcionario funcionarioUm,Funcionario funcionarioDois){
		if(funcionarioUm==null || funcionarioDois==null){
			return false;
		}
		if(funcionarioUm.getNome().equals(funcionarioDois.getNome()) && funcionarioUm.getSenha().equals(funcionarioDois.getSenha()))
			return true;
		
		return false;
	}
}
