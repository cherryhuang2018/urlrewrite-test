package com.kcc.controller;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RestObject {

  /** The key. */
  private UUID key;
  
  /** The status. */
  private Integer status;
  
  /** The errors. */
  private List<RestError> errors;

  /**
   * Gets the key.
   * 
   * @return the key
   */
  public UUID getKey() {
    return key;
  }

  /**
   * Sets the key.
   * 
   * @param key the new key
   */
  public void setKey(UUID key) {
    this.key = key;
  }

  /**
   * Gets the status.
   * 
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * Sets the status.
   * 
   * @param status the new status
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Gets the errors.
   * 
   * @return the errors
   */
  public List<RestError> getErrors() {
    return errors;
  }

  /**
   * Sets the errors.
   * 
   * @param errors the new errors
   */
  public void setErrors(List<RestError> errors) {
    this.errors = errors;
  }

}
