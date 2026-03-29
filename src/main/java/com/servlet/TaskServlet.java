package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TaskBean;
import com.repository.DBConnection;
import com.repository.TaskRepository;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if("List".equals(action)) {
			List<TaskBean> list = new TaskRepository().getAllList();
			request.setAttribute("taskList", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		if("Add".equals(action)) {
			TaskBean task = new TaskBean();
			task.setTitle(title);
			task.setDescription(description);
			task.setStatus("pending");
			
			TaskRepository.add(task);
			response.sendRedirect("task?action=List");
		}
		
	}

}
