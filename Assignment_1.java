package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Assignment_1 {

	public static void main(String[] args)throws SQLException{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null; 
		int checking=1; 
		Scanner scan=new Scanner(System.in); 
		String url="jdbc:mysql://localhost:3306/enterprice_java";
		String user="root";
		String password="Achari@2001";  
		try {
			 connection=DriverManager.getConnection(url, user, password); 
			 if(connection!=null) {
  	           statement=connection.createStatement();
			 }
		     while(checking==1) {
		          System.out.println("enter create to add data r select to read data r update to update data "
		     		+ "r delete to delete data  ");  
		          String value=scan.next(); 
		          switch(value) {
		             case "create" : try {
		        				         if(statement!=null) { 
		        				            System.out.println("enter e_id make sure u entered uniq value as it is primary key");
		        				            int e_id=scan.nextInt(); 
		        				          	System.out.println("Enter e_name ");
		        				          	String e_name=scan.next(); 
		        				          	System.out.println("enter e_dep "); 
		        				          	String e_dep=scan.next();
		        				         	System.out.println("enter e_loc"); 
		        				          	String e_loc=scan.next();      	
		        					        String insertSqlQuery=String.format("insert into employee values('%d','%s','%s','%s')",e_id,e_name,e_dep,e_loc);
		        					        int noOfRows=statement.executeUpdate(insertSqlQuery);
		        				            System.out.println("No of rows affected is:: "+noOfRows);
		        				         }  
		        		              }catch(SQLException e) {
		        			               e.printStackTrace();
		        		              } 
		                              break; 
		             case "select": try { 
		     			                if(statement!=null) { 
		    					           String sqlSelectQuery="select s_id,e_name,e_dep,e_loc from employee";
		    					           resultSet=statement.executeQuery(sqlSelectQuery);
		    					           if(resultSet!=null) { 
		    						          System.out.println("S_ID\tE_NAME\tE_DEP\tE_LOC");
		    						          System.out.println("------------------------------");
		    						          while(resultSet.next()) {
		    							          int id=resultSet.getInt("s_id");
		    							          String name=resultSet.getString("e_name");
		    							          String dep=resultSet.getString("e_dep");
		    						              String loc=resultSet.getString("e_loc");
		    					                  System.out.println(id+"\t"+name+"\t"+dep+"\t"+loc);
		    						          }
		    				               }
		    			                }
		    		                  }catch(SQLException e) {
		    		                	  e.printStackTrace();
		    		                  }break; 
		             case "update": try {
		    	        	            if(statement!=null) {  
		    	        	            	System.out.println("enter existed employee id");
		    	        	            	int id=scan.nextInt();
		    	        		            String updateQuery="update employee set e_loc='bangalore' where s_id="+id;
		    	        		            int noOfRowsAffected=statement.executeUpdate(updateQuery); 
		    	        		            System.out.println("No of rows affected:: "+noOfRowsAffected);
		    	                    	}
		    	        
		    	                    }catch(SQLException e) {
		    	                     	e.printStackTrace();
		    	                    }break; 
		             case "delete": try {
		    	        	            if(statement!=null) { 
		    	        	            	System.out.println("enter id to delete that row "); 
		    	        	            	int id=scan.nextInt();
		    	        		            String deleteSqlQuery="delete from employee where s_id="+id;
		    	        		            int noOfRowsAffected=statement.executeUpdate(deleteSqlQuery); 
		    	        		            System.out.println("No of rows deleted:: "+noOfRowsAffected);
		    	        	            }
		    	                    }catch(SQLException e) {
		    	    	                e.printStackTrace();
		    	                    }break;
		    	     default: System.out.println("hey! enter valid operation to work");
		       } 
		       System.out.println(); 
		       System.out.println("enter 1 to continue else 0");
		       checking=scan.nextInt();
		}
		}finally{ 
			if(resultSet!=null)
				resultSet.close();
			if(statement!=null)
				statement.close(); 
			if(connection!=null)
				connection.close(); 
			if(scan!=null)
				scan.close(); 
		    System.out.println("appliction terminted");
		}		
	}
}
