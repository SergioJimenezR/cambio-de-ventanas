import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private static Login mInstancia = null;

	private JFrame frame;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JButton btnIniciarSesion;

	public static Login getInstancia() {
		if (mInstancia == null)
			mInstancia = new Login();
		mInstancia.frame.setVisible(true);

		return mInstancia;
	}

	private Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(149, 110, 45, 13);
			frame.getContentPane().add(lblNombre);
		}
		{
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(204, 107, 96, 19);
			frame.getContentPane().add(textFieldNombre);
			textFieldNombre.setColumns(10);
		}
		{
			btnIniciarSesion = new JButton("Iniciar sesión");
			btnIniciarSesion.addActionListener(new BtnIniciarSesionActionListener());
			btnIniciarSesion.setBounds(149, 133, 151, 21);
			frame.getContentPane().add(btnIniciarSesion);
		}
	}

	private class BtnIniciarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			mInstancia = null;
			VentanaPrincipal.getInstancia(textFieldNombre.getText());
		}
	}
}
