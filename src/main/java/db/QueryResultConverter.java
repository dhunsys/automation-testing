package db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryResultConverter {
	private List<Map<String, Object>> resultSet = null;
	
	public QueryResultConverter(ResultSet resultSet) {
		convertResultSetToMapList(resultSet);
	}

	public Object getValue(int rowNumber, String columnName) {
		return resultSet.get(rowNumber - 1).get(columnName);
	}

	public int getRowCount() {
		return resultSet.size();
	}

    public int getColumnCount() {
        return resultSet.get(0).size();
    }
	
	public boolean isEmpty() {
		return resultSet.isEmpty();
	}
	
	public List<Map<String, Object>> getResultSet() {
		return resultSet;
	}
	
    /**
     * Helper method that maps a ResultSet into a list of maps, one per row
     * @param resultSet ResultSet
     * @return list of maps, one per column row, with column names as keys
     * @throws SQLException if the connection fails
     * ConsoleLogger.println(((LinkedHashMap)impactPageResultSet.get(4)).get("modtime"));
     */
    private void convertResultSetToMapList(ResultSet resultSet) {
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int numWantedColumns = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> row = new LinkedHashMap<String, Object>();

                for (int i = 0; i < numWantedColumns; ++i) {
                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    Object value = resultSet.getObject(columnName);
                    row.put(columnName, value);
                }

                rows.add(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        this.resultSet= rows;
    }
}
