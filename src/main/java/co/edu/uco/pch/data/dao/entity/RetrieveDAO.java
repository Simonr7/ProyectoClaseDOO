package co.edu.uco.pch.data.dao.entity;

import java.util.List;

interface RetrieveDAO <SR> {

	List<SR> retrieve(SR data);
	
}
