package co.edu.uco.pch.crosscutting.helpers;

import java.sql.Connection; 
import java.sql.SQLException;

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

public final class SQLHelper {

	private SQLHelper() {
		super();
	}

	public static final boolean isNull(final Connection connection) {
		return ObjectHelper.getObjectHelper().isNull(connection);
	}

	public static final boolean isOpen(final Connection connection) {
		try {
			return !isNull(connection) && !connection.isClosed();
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00007);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00008);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void close(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00009);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			connection.close();
		} catch (final CrosscuttingPCHExceptions exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00010);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00011);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void commit(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00012);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			if (connection.getAutoCommit()) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00013);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			connection.commit();
		} catch (final CrosscuttingPCHExceptions exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00014);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00015);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void rollback(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00016);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			if (connection.getAutoCommit()) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00017);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			connection.rollback();
		} catch (final CrosscuttingPCHExceptions exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00018);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00019);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void initTransaction(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00020);

				throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
			}

			connection.setAutoCommit(false);
		} catch (final CrosscuttingPCHExceptions exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00021);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenido(CodigoMensaje.M00022);

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario, exception);
		}
	}
}
