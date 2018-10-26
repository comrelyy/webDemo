package com.able.re.Mybatis.TypeHandler;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 继承BaseTypeHandler<T>实现类型转换
 *
 * @author cairuirui
 * @create 2018/10/26
 */
public class StringArray2StringHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setConfiguration(Configuration c) {
        super.setConfiguration(c);
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        super.setParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public String[] getResult(ResultSet rs, String columnName) throws SQLException {
        return super.getResult(rs, columnName);
    }

    @Override
    public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        return super.getResult(rs, columnIndex);
    }

    @Override
    public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return super.getResult(cs, columnIndex);
    }

    /**真正需要子类实现的方法**/
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        StringBuffer buffer = new StringBuffer();
        for (String s : parameter) {
            buffer.append(s).append(",");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        ps.setString(i,buffer.toString());
    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);
        return getStringArray(string);
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        return getStringArray(string);
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        return getStringArray(string);
    }

    private String[] getStringArray(String columnValue){
        if (columnValue == null) {
            return null;
        }
        return columnValue.split(",");
    }
}
