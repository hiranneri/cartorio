package vc.com.cartorios.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="tb_cartorios")
public class Cartorio {
	@Id
	@GeneratedValue(generator="incr")
	@GenericGenerator(name="incr", strategy="increment")
	private Long id;
	
	@Column(name="nm_cartorio", length=255, nullable=false)
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
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
		this.nome = nome;
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
