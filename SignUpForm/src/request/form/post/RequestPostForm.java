package request.form.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//web xml dosyasinda bulunan tanimlamalari iptal edip Annotation'lari kullanabiliriz.
//@WebServlet("/requestPostFormURL")
public class RequestPostForm extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		String age = req.getParameter("user_age");
		String bio = req.getParameter("user_bio");
		String job = req.getParameter("user_job");

		String[] interest = req.getParameterValues("user_interest");

		// Verilerimizi console ekranindan kontrol ediyoruz.
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(age);
		System.out.println(bio);
		System.out.println(job);

		for (String ints : interest) {

			System.out.println(ints);

		}

		// String dizimizi list yapisina ceviriyoruz.
		List<String> interest1 = Arrays.asList(interest);

		Person person = new Person(name, email, password, age, bio, job, interest1);
		req.setAttribute("myPerson", person);

		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);

	}

}
