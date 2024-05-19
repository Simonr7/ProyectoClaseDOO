package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.UNDERSCORE;

public enum CodigoMensaje {
	
	M00001(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00001", true),
	M00002(CategoriaMensaje.ERROR, TipoMensaje.USUARIO, "00002", true),
	M00003(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00003", true),
	M00004(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00004", true),
	M00005(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00005", true),
	M00006(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00006", true),
	M00007(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00007", true),
	M00008(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00008", true),
	M00010(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00010", false),
	M00009(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00009", true),
	M00011(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00011", true),
	M00012(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00012", true),
	M00013(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00013", true),
	M00014(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00014", true),
	M00015(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00015", true),
	M00016(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00016", true),
	M00017(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00017", true),
	M00018(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00018", true),
	M00019(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00019", true),
	M00020(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00020", true),
	M00021(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00021", true),
	M00022(CategoriaMensaje.ERROR, TipoMensaje.TECNICO, "00022", true);
	
	private CodigoMensaje(CategoriaMensaje categoria, TipoMensaje tipo, String id, final boolean base)
	{
		setCategoria(categoria);
		setTipo(tipo);
		setId(id);
		setIsBase(base);
	}
	
	private CategoriaMensaje categoria;
	private TipoMensaje tipo;
	private String id;
	private boolean base;

	public CategoriaMensaje getCategoria() {
		return this.categoria;
	}
	private void setCategoria(final CategoriaMensaje categoria) {
		this.categoria = categoria;
	}
	public TipoMensaje getTipo() {
		return this.tipo;
	}
	private void setTipo(final TipoMensaje tipo) {
		this.tipo = tipo;
	}
	public String getId() {
		return this.id;
	}
	private void setId(final String id) {
		this.id = id;
	}
	
	public boolean getIsBase()
	{
		return this.base;
	}
	
	private void setIsBase(final boolean base)
	{
		this.base = base;
	}
	
	public String getIdentifier()
	{
		return TextHelper.concatenate(this.getCategoria().name(), UNDERSCORE, this.getTipo().name(), UNDERSCORE, this.getId());
	}
}
