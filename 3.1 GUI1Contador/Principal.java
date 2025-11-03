import javax.swing.*; // Para SwingUtilities y UIManager.

/**
 * Punto de entrada de la aplicación.
 * Inicia la GUI en el Event Dispatch Thread (EDT) para garantizar seguridad de hilos en Swing.
 */
public class Principal {
    public static void main(String[] args) {
        /**
         * SwingUtilities.invokeLater(...) agenda la ejecución del bloque dentro del EDT (Event Dispatch Thread).
         * En Swing, casi todo el código que crea o modifica componentes debe ejecutarse en el EDT. Si no lo haces, puedes tener:
         *  - Condiciones de carrera o estados inconsistentes: la UI se construye o actualiza desde varios hilos y 
         *      queda “a medias”: textos que no aparecen, tamaños erróneos, listeners no registrados a tiempo.
         *  - Repintados impredecibles o glitches: componentes que no se dibujan o se dibujan tarde, parpadeo, layouts que no se aplican.
         *  - Bloqueos o deadlocks: si un hilo ajeno llama a métodos que esperan al EDT y el EDT a su vez espera al hilo ajeno ambos quedan detenidos.
         *  - Fallos intermitentes difíciles de reproducir: hoy funciona, mañana no; depende del timing del SO/CPU.
         * Reglas sanas:
         *  - Crear y tocar la UI en el EDT: SwingUtilities.invokeLater(() -> new MiVentana().setVisible(true));
         *  - Tareas pesadas fuera del EDT (para no “congelar” la ventana), y al terminar volver al EDT para actualizar la UI 
         *      (por ejemplo con SwingWorker o SwingUtilities.invokeLater).
         *  - No uses invokeAndWait desde el EDT (lanza deadlock).
         */
        SwingUtilities.invokeLater(() -> {
            try {
                // Opcional: establece el "Look & Feel" del sistema operativo
                // (para que botones, fuentes y bordes se vean nativos).
                // for (var info : UIManager.getInstalledLookAndFeels()) {
                //     System.out.println(info.getName() + " -> " + info.getClassName());
                // }
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {
                // Si falla (por ejemplo, si no identifica al SO), simplemente ignora y usa el L&F por defecto.
            }

            // Crea e inicializa la ventana principal (MiInterfaz).
            // El constructor se encarga de: setContentPane(...), pack(), centrar y setVisible(true).
            new MiInterfaz();
        });
        /**
         * puedes elegir el Look & Feel (L&F) que controla la apariencia (botones, bordes, fuentes, etc.). Esa línea:
         *      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         * pone el L&F del sistema operativo (Windows, GTK en Linux, Aqua en macOS). Pero hay otras opciones, las comunes son:
         *      Del sistema (nativo):
         *          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         *      Aspecto similar al SO (lo más “nativo” posible).
         * 
         *      Multiplataforma (cross-platform / Metal):
         *          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
         *      Apariencia uniforme en todos los SO (tradicional “Metal”).
         * 
         *      Nimbus (incluido en el JDK):
         *          for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
         *              if ("Nimbus".equals(info.getName())) {
         *                  UIManager.setLookAndFeel(info.getClassName());
         *                  break;
         *              }
         *          }
         *      Más moderno que Metal, mantiene consistencia entre plataformas.
         */
    }
}
