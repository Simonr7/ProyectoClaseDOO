package co.edu.uco.pch.controller.response;

import java.util.ArrayList;

import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadResponse extends Response<CiudadDTO>{

	public CiudadResponse() {
		setMensajes(new ArrayList<>(0));
		setDatos(new ArrayList<>());
	}
}
