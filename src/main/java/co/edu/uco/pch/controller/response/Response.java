package co.edu.uco.pch.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	private List<String> mensajes = new ArrayList<String>();
	private List<T> datos;

}
