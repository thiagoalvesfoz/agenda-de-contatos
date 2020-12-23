package com.agenda.api.exceptions.exceptionhandler;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseApi {

	private Integer status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private String title;
	private String path;
	private List<Field> fields;
	
	public ResponseApi() {}
	
	public ResponseApi(Integer statusHttp, Instant timestamp, String title, String path) {
		this.status = statusHttp;
		this.timestamp = timestamp;
		this.title = title;
		this.path = path;
	}
	
	
	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public Instant getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public List<Field> getFields() {
		return fields;
	}



	public void setFields(List<Field> fields) {
		this.fields = fields;
	}



	public static class Field {		
		private String name;
		private String message;
		
		public Field() {}
		
		public Field(String name, String message) {
			this.name = name;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
