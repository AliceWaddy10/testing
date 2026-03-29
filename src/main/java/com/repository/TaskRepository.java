package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.TaskBean;

public class TaskRepository {

	public static  int add(TaskBean obj) {
		
		String sql = "INSERT INTO TASKS(title,description,status) values (?,?,?)";
		int i = 0;
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getDescription());
			ps.setString(3, obj.getStatus());
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Add SQL error : "+e.getMessage());
		}
		return i;
	}
	
	public TaskBean findById(TaskBean obj) {
		TaskBean task =null;
		Connection con = DBConnection.getConnection();
		String sql = "select * from tasks where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setDescription(rs.getString("description"));
				task.setStatus(rs.getString("status"));
			}
			
		} catch (SQLException e) {
			System.out.println("Find By id SQL error : "+e.getMessage());
		}
		
		return task;		
	}
	
	public List<TaskBean> getAllList() {		
		
		Connection con = DBConnection.getConnection();
		
		List<TaskBean> listAll = new ArrayList<>();
		
		String sql = "select * from tasks";
		try {
			PreparedStatement ps = con.prepareStatement(sql);			
			
			ResultSet rs = ps.executeQuery(); 	
			while(rs.next()) {
				TaskBean task = new TaskBean();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setDescription(rs.getString("description"));
				task.setStatus(rs.getString("status"));
				listAll.add(task);
			}
						
		} catch (SQLException e) {
			System.out.println("list sql error : "+e.getMessage());
		}
		return listAll;		
	}
}
