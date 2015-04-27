package com.xdev.template.rest.resource;

public class Message {

	private int code;

	private MessageType type;

	private String message;

	public Message() {
		super();
	}

	public Message(int code, MessageType type, String message) {
		super();
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", type=" + type + ", message=" + message + "]";
	}

	public static class Builder {
		private int code;
		private MessageType type;
		private String message;

		public Builder code(int code) {
			this.code = code;
			return this;
		}

		public Builder type(MessageType messageType) {
			this.type = messageType;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Message build() {
			return new Message(code, type, message);
		}

		public static Builder getInstace() {
			return new Builder();
		}

		public static Builder info(String message) {
			return getInstace().type(MessageType.INFO).message(message);
		}

		public static Builder warn(String message) {
			return getInstace().type(MessageType.WARN).message(message);
		}

		public static Builder error(String message) {
			return getInstace().type(MessageType.ERROR).message(message);
		}

	}
}
