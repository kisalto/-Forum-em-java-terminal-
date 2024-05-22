package model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personagem")
public class Personagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personagem_id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "img")
	private String imgUrl;
	
	@OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
	private List<Guia> guia;
	
	@ManyToOne
    @JoinColumn(name = "fk_jogo_id")
    private Jogo jogo;
	
	public Personagem() {
		
	}
	
	public Personagem(Long id, String nome, String descricao, String tipo, String imgUrl, List<Guia> guia, Jogo jogo){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.imgUrl = imgUrl;
		this.guia = guia;
		this.jogo = jogo;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Guia> getGuia() {
		return guia;
	}

	public void setGuia(List<Guia> guia) {
		this.guia = guia;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}
