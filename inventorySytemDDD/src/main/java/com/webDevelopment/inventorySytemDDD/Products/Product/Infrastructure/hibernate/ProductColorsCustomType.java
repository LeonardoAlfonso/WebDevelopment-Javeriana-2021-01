package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.hibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ProductColorDetails;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ProductDetail;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductColorsCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR };
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<ProductColorDetails> response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));

            if (value.isPresent())
            {
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(color->
                        new ProductColorDetails((String)color.get("id"), (String)color.get("name"), (Integer)color.get("quantity"), (Boolean)color.get("hasStock"), (String)color.get("rgb"))
                ).collect(Collectors.toList());
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error at reading map", e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<ProductColorDetails>> colors = (value == null) ? Optional.empty() : (Optional<List<ProductColorDetails>>)value;
        try {
            if (colors.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String, Object>> objects = colors.get().stream().map(color -> color.data()).collect(Collectors.toList());
                String serializedList = mapper.writeValueAsString(objects).replace("\\","");
                st.setString(index, serializedList);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
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
}
