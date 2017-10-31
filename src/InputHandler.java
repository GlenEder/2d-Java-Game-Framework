import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener{
	

	public InputHandler() {
		Display.getFrame().addKeyListener(this);
		Display.getFrame().addMouseListener(this);
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();			
	}

	public void keyTyped(KeyEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}
}