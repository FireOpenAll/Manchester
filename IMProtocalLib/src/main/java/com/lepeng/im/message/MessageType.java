package com.lepeng.im.message;

public enum MessageType {
	/**
	 * 点对点
	 */
	P2P(1),
	/**
	 * 分组消息
	 */
	GROUP(2),

	/**
	 * 通知
	 */
	NOTIFICATION(3);
	private final Integer value;

	private MessageType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static MessageType toEnum(Integer value) {
		for (MessageType item : values()) {
			if (item.getValue().equals(value)) {
				return item;
			}
		}
		return null;
	}

}
