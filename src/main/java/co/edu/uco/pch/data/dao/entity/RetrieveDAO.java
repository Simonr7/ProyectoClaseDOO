package co.edu.uco.pch.data.dao.entity;

import java.util.List;

public interface RetrieveDAO<SW> {
	
	List<SW> consultar(SW data);

}
