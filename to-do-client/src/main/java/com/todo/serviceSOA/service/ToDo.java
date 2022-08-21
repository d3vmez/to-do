/**
 * ToDo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.todo.serviceSOA.service;

public class ToDo  implements java.io.Serializable {
    private java.lang.String description;

    private com.todo.serviceSOA.service.Date endDate;

    private int id;

    private java.lang.String name;

    private com.todo.serviceSOA.service.Date starDate;

    private com.todo.serviceSOA.service.ToDoStatus toDoStatus;

    public ToDo() {
    }

    public ToDo(
           java.lang.String description,
           com.todo.serviceSOA.service.Date endDate,
           int id,
           java.lang.String name,
           com.todo.serviceSOA.service.Date starDate,
           com.todo.serviceSOA.service.ToDoStatus toDoStatus) {
           this.description = description;
           this.endDate = endDate;
           this.id = id;
           this.name = name;
           this.starDate = starDate;
           this.toDoStatus = toDoStatus;
    }


    /**
     * Gets the description value for this ToDo.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ToDo.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the endDate value for this ToDo.
     * 
     * @return endDate
     */
    public com.todo.serviceSOA.service.Date getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this ToDo.
     * 
     * @param endDate
     */
    public void setEndDate(com.todo.serviceSOA.service.Date endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the id value for this ToDo.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this ToDo.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this ToDo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ToDo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the starDate value for this ToDo.
     * 
     * @return starDate
     */
    public com.todo.serviceSOA.service.Date getStarDate() {
        return starDate;
    }


    /**
     * Sets the starDate value for this ToDo.
     * 
     * @param starDate
     */
    public void setStarDate(com.todo.serviceSOA.service.Date starDate) {
        this.starDate = starDate;
    }


    /**
     * Gets the toDoStatus value for this ToDo.
     * 
     * @return toDoStatus
     */
    public com.todo.serviceSOA.service.ToDoStatus getToDoStatus() {
        return toDoStatus;
    }


    /**
     * Sets the toDoStatus value for this ToDo.
     * 
     * @param toDoStatus
     */
    public void setToDoStatus(com.todo.serviceSOA.service.ToDoStatus toDoStatus) {
        this.toDoStatus = toDoStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToDo)) return false;
        ToDo other = (ToDo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.starDate==null && other.getStarDate()==null) || 
             (this.starDate!=null &&
              this.starDate.equals(other.getStarDate()))) &&
            ((this.toDoStatus==null && other.getToDoStatus()==null) || 
             (this.toDoStatus!=null &&
              this.toDoStatus.equals(other.getToDoStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getStarDate() != null) {
            _hashCode += getStarDate().hashCode();
        }
        if (getToDoStatus() != null) {
            _hashCode += getToDoStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToDo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.serviceSOA.todo.com/", "toDo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.serviceSOA.todo.com/", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("starDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "starDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.serviceSOA.todo.com/", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toDoStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toDoStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.serviceSOA.todo.com/", "toDoStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
