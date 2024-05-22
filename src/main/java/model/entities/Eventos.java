package model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Eventos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventos_id")
	private Long id;

	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "banner")
	private String bannerUrl;
	
	@Column(name = "dia")
	private String dia;
	
	@OneToMany(mappedBy = "eventos", cascade = CascadeType.ALL)
	private List<UltimoEvento> ultimoEvento;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "fk_jogo_id")
	private Jogo jogo;
	
	public Eventos() {
		
	}
	
	public Eventos(Long id, String titulo, String descricao, String bannerUrl, String dia, List<UltimoEvento> ultimoEvento, Usuario usuario, Jogo jogo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.bannerUrl = bannerUrl;
		this.dia = dia;
		this.ultimoEvento = ultimoEvento;
		this.usuario = usuario;
		this.jogo = jogo;
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

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public List<UltimoEvento> getUltimoEvento() {
		return ultimoEvento;
	}

	public void setUltimoEvento(List<UltimoEvento> ultimoEvento) {
		this.ultimoEvento = ultimoEvento;
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
	
}
