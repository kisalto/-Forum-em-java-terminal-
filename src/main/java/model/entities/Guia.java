package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "guia")
public class Guia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guia_id")
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "data_cr")
	private String dataCr;
	
	@Column(name = "dislikes")
	private int dislikes;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "link")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "fk_jogo_id")
	private Jogo jogo;
	
	@ManyToOne
	@JoinColumn(name = "fk_personagem_id")
	private Personagem personagem;
	
	public Guia () {
		
	}
	
	public Guia (Long id, String titulo, String descricao, String tipo, String dataCr, int dislikes, int likes, String url, Usuario usuario, Jogo jogo, Personagem personagem) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataCr = dataCr;
		this.dislikes = dislikes;
		this.likes = likes;
		this.url = url;
		this.usuario = usuario;
		this.jogo = jogo;
		this.personagem = personagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public String getDataCr() {
		return dataCr;
	}

	public void setDataCr(String dataCr) {
		this.dataCr = dataCr;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

}
