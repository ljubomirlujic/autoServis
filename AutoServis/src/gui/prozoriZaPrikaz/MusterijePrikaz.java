package gui.prozoriZaPrikaz;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import autoServis.AutoServis;

public class MusterijePrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable servisiTabela;
	private AutoServis autoServis;
	
	public  MusterijePrikaz(AutoServis autoServis) {
		this.autoServis = autoServis;
		setTitle("Servisi prikaz");
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		InitGUI();
		InitAction();
	}
	private void InitGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		String[] zaglavlja = new String[] {"ID", "Naziv", "Cena", "Izvodjac", "Zanr"};
//		Object[][] sadrzaj = new Object[prodavnica.sviNeobrisaniDiskovi().size()][zaglavlja.length];
	}
	private void InitAction() {
		
	}
}
