package model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "apelido")
	private String nickname;
	
	@Column(name = "senha")
	private String password;
	
	@Column(name = "data_reg")
	private String dataReg;
	
	@Column(name = "dc_id")
	private String dcId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "eventos_qnt")
	private int eventosQnt;
	
	@Column(name = "guias_qnt")
	private int guiasQnt;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Guia> guia;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Eventos> eventos;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nickname, String password, String dataReg, String dcId, String email, int eventosQnt, int guiasQnt, List<Guia> guia, List<Eventos> eventos) {
		this.nickname = nickname;
		this.dataReg = dataReg;
		this.dcId = dcId;
		this.email = email;
		this.eventosQnt = eventosQnt;
		this.guiasQnt = guiasQnt;
		this.password = password;
		this.guia = guia;
		this.eventos = eventos;
	}
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDataReg() {
		return dataReg;
	}

	public void setDataReg(String dataReg) {
		this.dataReg = dataReg;
	}

	public String getDcId() {
		return dcId;
	}

	public void setDcId(String dcId) {
		this.dcId = dcId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEventosQnt() {
		return eventosQnt;
	}

	public void setEventosQnt(int eventosQnt) {
		this.eventosQnt = eventosQnt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGuiasQnt() {
		return guiasQnt;
	}

	public void setGuiasQnt(int guiasQnt) {
		this.guiasQnt = guiasQnt;
	}

	public List<Guia> getGuia() {
		return guia;
	}

	public void setGuia(List<Guia> guia) {
		this.guia = guia;
	}

	public List<Eventos> getEventos() {
		return eventos;
	}

	public void setEventos(List<Eventos> eventos) {
		this.eventos = eventos;
	}
	
	
	
}
