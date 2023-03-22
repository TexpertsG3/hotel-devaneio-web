package br.com.hotel.devaneio.servlet;

import java.io.IOException;
import java.sql.SQLException;

import br.com.hotel.devaneio.dao.CargoDao;
import br.com.hotel.devaneio.modelo.Cargo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastracargo")
public class CadastraCargo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cargo = req.getParameter("cargo");

		Cargo cargo2 = new Cargo(cargo);

		CargoDao cargoDao = new CargoDao();
		try {
			cargoDao.insere(cargo2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaCargo");

	}

}
