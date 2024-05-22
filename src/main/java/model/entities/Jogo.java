package model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "jogo")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jogo_id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Column(name = "link")
	private String url;
	
	@Column(name = "totaleventos")
	private int totalEventos;
	
	@Column(name = "totalguias")
	private int totalGuias;
	
	@OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
	private List<Guia> guia;

	@OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
	private List<Personagem> personagem;
	
	public Jogo() {
		
	}
	
	public Jogo(long id, String nome, String descricao, BigDecimal preco, String url, int totalEventos, int totalGuias, List<Guia> guia, List<Personagem> personagem) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.url = url;
		this.totalEventos = totalEventos;
		this.totalGuias = totalGuias;
		this.guia = guia;
		this.personagem = personagem;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalEventos() {
		return totalEventos;
	}

	public void setTotalEventos(int totalEventos) {
		this.totalEventos = totalEventos;
	}

	public int getTotalGuias() {
		return totalGuias;
	}

	public void setTotalGuias(int totalGuias) {
		this.totalGuias = totalGuias;
	}

	public List<Guia> getGuia() {
		return guia;
	}

	public void setGuia(List<Guia> guia) {
		this.guia = guia;
	}

	public List<Personagem> getPersonagem() {
		return personagem;
	}

	public void setPersonagem(List<Personagem> personagem) {
		this.personagem = personagem;
	}
	
}
