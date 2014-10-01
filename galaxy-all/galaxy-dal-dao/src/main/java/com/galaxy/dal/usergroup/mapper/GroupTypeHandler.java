package com.galaxy.dal.usergroup.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.galaxy.dal.domain.usergroup.GroupType;

public class GroupTypeHandler extends BaseTypeHandler<GroupType> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			GroupType parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i, parameter.name());
	}

	@Override
	public GroupType getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		int index = rs.findColumn(columnName);
		return getNullableResult(rs, index);
	}

	@Override
	public GroupType getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String name = rs.getString(columnIndex);
		if (name == null || name.trim().length() <= 0) {
			return null;
		}
		return GroupType.valueOf(name);
	}

	@Override
	public GroupType getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String name =cs.getString(columnIndex);
		if (name == null || name.trim().length() <= 0) {
			return null;
		}
		return GroupType.valueOf(name);
	}

}
