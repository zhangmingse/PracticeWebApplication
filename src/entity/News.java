package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;


@Entity
@Table(name="news_inf")
public class News {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;
	@Formula("(select concat(nt.title,nt.content) from news_inf nt where nt.id = id)")
	private String fullcontent;
	public String getFullcontent() {
		return fullcontent;
	}
	public void setFullcontent(String fullcontent) {
		this.fullcontent = fullcontent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
