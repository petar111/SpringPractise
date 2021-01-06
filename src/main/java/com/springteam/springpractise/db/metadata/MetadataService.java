/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springteam.springpractise.db.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siux
 */
@Service
public class MetadataService {
    
    
    private final DataSource dataSource;

    @Autowired
    public MetadataService(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<String> getTableNames() throws SQLException{
        
        Connection conn = dataSource.getConnection();
        
        DatabaseMetaData metadata = conn.getMetaData();
        
        
        ResultSet rs = metadata.getTables(null, "public", null, new String[]{"TABLE"});
        
        List<String> tableNames = new ArrayList<>();
        
        while(rs.next()){
            tableNames.add(rs.getString(1));
            tableNames.add(rs.getString(2));
            tableNames.add(rs.getString(3));
            tableNames.add(rs.getString(4));
            tableNames.add(rs.getString(5));
            tableNames.add(rs.getString(6));
            tableNames.add(rs.getString(7));
            tableNames.add(rs.getString(8));
            tableNames.add(rs.getString(9));
            tableNames.add(rs.getString(10));
        }
        
        
        return tableNames;
    }
    
    public List<String> getColumnNamesByTableName(String tableName) throws SQLException, InterruptedException{
        
        Connection conn = dataSource.getConnection();
        
        
        DatabaseMetaData metadata = conn.getMetaData();
        
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CLOSE_CURSORS_AT_COMMIT);
        
        System.out.println(metadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        
        ResultSet rs1 = s.executeQuery("SELECT * FROM player");
        
        System.out.println("Before change....");
        while(rs1.next()){
            System.out.println(rs1.getString("name"));
        }
        
        Thread.sleep(20000);
        
        
        rs1.beforeFirst();
        
        System.out.println("After change....");
        while(rs1.next()){
            System.out.println(rs1.getString("name"));
        }
        
        
        ResultSet rs = metadata.getColumns(null, "public", tableName, null);
        
//        System.out.println(metadata.getURL());
        
        List<String> columnNames = new ArrayList<>();
        
        while(rs.next()){
            columnNames.add(rs.getString(4));
        }
        
        
        return columnNames;
    }

    
    
    
    
    
}
