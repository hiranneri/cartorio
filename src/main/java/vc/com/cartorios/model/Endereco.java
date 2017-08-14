package vc.com.cartorios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name="inc", strategy="increment")
	private Long id;
	
	@Column(name="ds_rua", nullable=false, length=255)
	@NotNull(message="O nome da rua é obrigatório")
	@Size(max=255, message="Máximo 255 caracteres")
	@NotBlank(message="O nome da rua é obrigatório")
	private String rua;
	
	
	@Column(name="nm_cartorio",nullable=false)
	@NotNull
	@Min(value=1)
	private int numero;
	
	@Column(name="ds_bairro",nullable=false, length=128)
	@NotNull(message="O nome do bairro é obrigatório")
	@Size(max=128)
	@NotBlank(message="O nome do bairro é obrigatório")
	private String bairro;
	
	@Column(name="ds_cidade",nullable=false,length=255)
	@NotNull
	@Size(max=255)
	@NotBlank(message="O nome da cidade é obrigatório")
	private String cidade;
	
	@Column(name="ds_estado",nullable=false,length=128)
	@NotNull
	@Size(max=128)
	@NotBlank(message="O nome do estado é obrigatório")
	private String estado;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua.trim();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.trim();
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.trim();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado.trim();
	}
	public String toString(){
		return "Endereço :"+this.rua+" "+this.numero+" "+this.bairro;
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
		final Endereco outro = (Endereco)objeto;
		if(id==null){
			if(outro.id !=null)
				return false;
		}else if(!id.equals(outro.id))
			return false;
		return true;
	}
	
}
