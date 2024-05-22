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
@Table(name = "ultimo_evento")
public class UltimoEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "jogo")
	private String game;
	
	@ManyToOne
	@JoinColumn(name = "fk_eventos_id")
	private Eventos eventos;
	
	@ManyToOne
	@JoinColumn(name = "fk_jogo_id")
	private Jogo jogo;
	
	public UltimoEvento() {
		
	}
	
	public UltimoEvento(Long id, String titulo, String game, Eventos eventos, Jogo jogo) {
		this.id = id;
		this.titulo = titulo;
		this.game = game;
		this.eventos = eventos;
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

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public Eventos getEventos() {
		return eventos;
	}

	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}
