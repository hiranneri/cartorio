package vc.com.cartorios.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@NamedQuery(name="Cartorio.nome", query="SELECT c FROM Cartorio c where c.nome LIKE :nome")
@Entity
@Table(name="tb_cartorios")
public class Cartorio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="incr")
	@GenericGenerator(name="incr", strategy="increment")
	private Long id;
	
	@Column(name="nm_cartorio", length=255, nullable=false)
	@NotNull
	@Size(max=254, message="Máximo 254 caracteres")
	@NotBlank(message="Nome do cartório obrigatório")
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	@NotNull
	private Endereco endereco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.trim();
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String toString(){
		return "Cartório "+this.nome;
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
		final Cartorio outro = (Cartorio)objeto;
		if(id==null){
			if(outro.id !=null)
				return false;
		}else if(!id.equals(outro.id))
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
}
