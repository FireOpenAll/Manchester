package com.lepeng.domain;



/**
 * The Class Product.
 */
public class Product extends BaseEntity implements java.io.Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 575607322950636578L;
				
	/**
	 * The Enum Status.
	 */
	public enum Status  {
		
		/** The Disable. */
		Disable,
		/** The Enalbe. */
		Enalbe;

		/**
		 * Gets the status.
		 *
		 * @return the status
		 */
		public short getstatus() {
			return Integer.valueOf(this.ordinal()).byteValue();
		}

	}

	/** The id. */
	private Integer id;
	
	/** 网站名称. */
	private String name;						
	
				
	
	/**  状态：0已删除，1有效. */
	private Short status;



	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Short getStatus() {
		return status;
	}



	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Short status) {
		this.status = status;
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	


}