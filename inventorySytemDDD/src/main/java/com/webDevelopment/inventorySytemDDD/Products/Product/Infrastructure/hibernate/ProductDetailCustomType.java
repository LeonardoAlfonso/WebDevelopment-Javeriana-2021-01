package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetail;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class ProductDetailCustomType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
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
        ProductDetail response = null;
        try{
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                HashMap<String, Object> mapper = new ObjectMapper().readValue(value.get(), HashMap.class);
                response = new ProductDetail((String) mapper.get("id"), (String) mapper.get("detail"));
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error ar reading map", e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<ProductDetail> detail = (value == null) ? Optional.empty() : (Optional<ProductDetail>) value;
        try {
            if(detail.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                String serializedObject = mapper.writeValueAsString(detail.get().data());
                st.setString(index, serializedObject);
            }
        }
        catch (Exception e) {
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
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
