import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private static VentanaPrincipal mInstancia = null;

	private JFrame frame;
	private JLabel lblBienvenida;
	private JButton btnCerrarSesion;

	public static VentanaPrincipal getInstancia(String nombre) {
		if (mInstancia == null)
			mInstancia = new VentanaPrincipal(nombre);
		mInstancia.frame.setVisible(true);

		return mInstancia;
	}

	private VentanaPrincipal(String nombre) {
		initialize(nombre);
	}

	private void initialize(String nombre) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			lblBienvenida = new JLabel("¡Bienvenido, " + nombre + "!");
			lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			lblBienvenida.setBounds(152, 98, 135, 21);
			frame.getContentPane().add(lblBienvenida);
		}
		{
			btnCerrarSesion = new JButton("Cerrar sesión");
			btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
			btnCerrarSesion.setBounds(152, 129, 135, 21);
			frame.getContentPane().add(btnCerrarSesion);
		}
	}

	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			mInstancia = null;
			Login.getInstancia();
		}
	}

}
