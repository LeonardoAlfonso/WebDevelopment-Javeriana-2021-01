package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.hibernate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ProductDetail;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetailDescription;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetailId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

public class JsonCustomType implements UserType, DynamicParameterizedType {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return ProductDetail.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x,y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        HashMap<String, String> mapper;
        ProductDetail response = null;
        try {
            String value  = rs.getString(names[0]);
            mapper = new ObjectMapper().readValue(value, HashMap.class);
            response = new ProductDetail(new ProductDetailId(mapper.get("id")), new ProductDetailDescription(mapper.get("details")));
        }
        catch (Exception e) {
            throw new HibernateException("Error at reading map", e);
        }

        return response;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        try {
            if (value == null) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                ProductDetail detail = (ProductDetail)value;
                String serializedObject = mapper.writeValueAsString(detail.data());
                st.setString(index, serializedObject);
            }
        } catch (IOException e) {
            throw new HibernateException("Exception serializing value " + value, e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }

    @Override
    public void setParameterValues(Properties parameters) {
        try {
            Class<?> entityClass = Class.forName(parameters.getProperty("detail"));

            JavaType valueType = new ObjectMapper().getTypeFactory().constructCollectionType(ArrayList.class, entityClass);
//            classType = List.class;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
