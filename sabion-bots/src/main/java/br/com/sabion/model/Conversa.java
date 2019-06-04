package br.com.sabion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conversa")
public class Conversa implements DTO {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="data_conversa")
	private Date dataDaConversa;
	
	@ManyToOne
	@JoinColumn(name="bot_id", nullable=false)
	private Bot bot;
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="bot")
	private List<MsgDeConversa> mensagens;

	@Override
	public Long getId() {
		return id;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}

	public List<MsgDeConversa> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MsgDeConversa> mensagens) {
		this.mensagens = mensagens;
	}

	public Date getDataDaConversa() {
		return dataDaConversa;
	}

	public void setDataDaConversa(Date dataDaConversa) {
		this.dataDaConversa = dataDaConversa;
	}
	
	

}
