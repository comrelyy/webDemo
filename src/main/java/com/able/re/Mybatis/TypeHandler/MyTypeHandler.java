package com.able.re.Mybatis.TypeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现TypeHandler<T>接口创建一个自己的类型转换器
 * @author cairuirui
 * @create 2018/10/26
 */
public class MyTypeHandler implements TypeHandler<Boolean> {

    /**
     * 用于定义在mybatis设置参数时，该如何把java类型的参数转换为数据库类型
     * @param ps
     * @param i 当前参数的位置
     * @param parameter 当前参数的java对象
     * @param jdbcType 当前参数的数据库类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if (parameter) {
            ps.setInt(i,1);
        }else {
            ps.setInt(i,0);
        }
    }

    /**
     * 用于定义在获取到结果集时如何把数据库类型转换为对应的java类型（通过列名来映射）
     * @param rs 结果集
     * @param columnName 数据库列名
     * @return
     * @throws SQLException
     */
    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        int anInt = rs.getInt(columnName);
        return anInt == 1;
    }

    /**
     * 用于定义在获取到结果集时如何把数据库类型转换为对应的java类型（通过列的位置来映射）
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        int anInt = rs.getInt(columnIndex);
        return anInt == 1;
    }

    /**
     * 用于定义在执行完存储过程之后将数据库类型转换为对应的java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        return anInt == 1;
    }
}
