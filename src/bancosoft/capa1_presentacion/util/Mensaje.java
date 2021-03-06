package bancosoft.capa1_presentacion.util;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author estal
 */
public class Mensaje {

    private static final String filaNoSeleccionada = "Seleccione una fila.";
    private static final String filaNoExiste = "La fila seleccionada ya no existe.";
    private static final String errorDeConsulta = "No se pudo realizar la consulta, intente de nuevo o consulte con el Administrador.";
    private static final String preguntaDeEliminacion = "¿Está seguro de eliminar?";
    private static final String afirmacionDeEliminacion = "El registro fue eliminado.";
    private static final String advertenciaDeEliminacion = "El registro no puede ser eliminado, verifique.";
    private static final String errorDeEliminacion = "No se pudo eliminar, intente de nuevo o consulte con el Administrador.";
    private static final String afirmacionDeCreacion = "Los datos fueron guardados Correctamente.";
    private static final String advertenciaDeCreacion = "Los datos no fueron guardados, verifique.";
    private static final String errorDeCreacion = "No se pudieron guardar los datos.\n"
            + "Verifique los datos obligatorios y únicos.\n"
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String afirmacionDeActualizacion = "Los datos fueron actualizados.";
    private static final String advertenciaDeActualizacion = "Los datos no fueron actualizados, verifique.";
    private static final String errorDeActualizacion = "No se pudieron actualizar los datos.\n"
            + "Verifique los datos obligatorios y únicos.\n"
            + "intente de nuevo o consulte con el Administrador.";
    private static final String advertenciaDeExceso = "El cliente tiene el maximo de prestamos.\n"
            + "No califica para adquirir uno mas.";
    private static final String preguntadePermanecia = "Desea Realizar Otra Transaccion?";
    private static final String preguntaConfirmacion = "Confirme la Transaccion";

    /**
     * No se pudo realizar la consulta, intente de nuevo o consulte con el
     * Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeConsulta(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, errorDeConsulta, "BancoSoft: Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * ¿Está seguro de eliminar?
     *
     * @param dialogo
     * @return
     */
    public static boolean mostrarPreguntaDeConfirmacion(JDialog dialogo) {
        int respuesta = JOptionPane.showConfirmDialog(dialogo, preguntaConfirmacion, "BancoSoft: Pregunta", JOptionPane.OK_CANCEL_OPTION);
        return (respuesta == JOptionPane.OK_OPTION);
    }

    public static void mostrarAlertaExceso(JDialog dialog) {
        JOptionPane.showMessageDialog(dialog, advertenciaDeExceso, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public static boolean mostrarPreguntaDePermanencia(JDialog dialogo) {
        int respuesta = JOptionPane.showConfirmDialog(dialogo, preguntadePermanecia, "BancoSoft: Pregunta", JOptionPane.YES_NO_OPTION);
        return (respuesta == JOptionPane.YES_OPTION);
    }

    public static boolean mostrarPreguntaDeEliminacion(JDialog dialogo) {
        int respuesta = JOptionPane.showConfirmDialog(dialogo, preguntaDeEliminacion, "BancoSoft: Pregunta", JOptionPane.YES_NO_OPTION);
        return (respuesta == JOptionPane.YES_OPTION);
    }

    public static void mostrarFilaNoExiste(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, filaNoExiste, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * El registro fue eliminado.
     *
     * @param dialogo
     */
    public static void mostrarAfirmacionDeEliminacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, afirmacionDeEliminacion, "BancoSoft: Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * El registro no puede ser eliminado, verifique.
     *
     * @param dialogo
     */
    public static void mostrarAdvertenciaDeEliminacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, advertenciaDeEliminacion, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * No se pudo eliminar, intente de nuevo o consulte con el Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeEliminacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, errorDeEliminacion, "BancoSoft: Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Los datos fueron guardados.
     *
     * @param dialogo
     */
    public static void mostrarAfirmacionDeCreacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, afirmacionDeCreacion, "BancoSoft: Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Los datos no fueron guardados, verifique.
     *
     * @param dialogo
     */
    public static void mostrarAdvertenciaDeCreacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, advertenciaDeCreacion, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * No se pudieron guardar los datos, intente de nuevo o consulte con el
     * Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeCreacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, errorDeCreacion, "BancoSoft: Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Los datos fueron actualizados.
     *
     * @param dialogo
     */
    public static void mostrarAfirmacionDeActualizacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, afirmacionDeActualizacion, "BancoSoft: Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Los datos no fueron actualizados, verifique.
     *
     * @param dialogo
     */
    public static void mostrarAdvertenciaDeActualizacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, advertenciaDeActualizacion, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * No se pudieron actualizar los datos, intente de nuevo o consulte con el
     * Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeActualizacion(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, errorDeActualizacion, "BancoSoft: Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de afirmación
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarAfirmacion(JDialog dialogo, String mensaje) {
        JOptionPane.showMessageDialog(dialogo, mensaje, "BancoSoft: Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de advertencia
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarAdvertencia(JDialog dialogo, String mensaje) {
        JOptionPane.showMessageDialog(dialogo, mensaje, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra un mensaje de error
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarError(JDialog dialogo, String mensaje) {
        JOptionPane.showMessageDialog(dialogo, mensaje, "BancoSoft: Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarInformacion(JDialog dialogo, String mensaje) {
        JOptionPane.showMessageDialog(dialogo, mensaje, "BancoSoft: Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarFilaNoSeleccionada(JDialog dialogo) {
        JOptionPane.showMessageDialog(dialogo, filaNoSeleccionada, "BancoSoft: Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
