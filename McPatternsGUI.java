import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class McPatternsGUI extends JFrame{
	McPatternsPresenter presenter;

	public McPatternsGUI(McPatternsPresenter presenter) {

		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}
	private void showGUI() {
		presenter.loadMenuItems();

		JFrame theFrame = new JFrame("McPatterns Register");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());

		//Title
		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome to McPatterns"));

		//Page Selection CENTER
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
		JLabel display = new JLabel("Display");
		displayPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		displayPanel.add(display);
		displayPanel.setPreferredSize(new Dimension(60, 60));

		//Place or Cancel Order EAST
		JPanel orderPane = new JPanel();
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		JLabel orderDetails = new JLabel("Your order");
		orderPane.add(orderDetails);
		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		JTextField ccEntry = new JTextField("Enter CC #");

		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new Action());

		class Action implements ActionListener{
        		public void actionPerformed(ActionEvent e) {
        		}
    		}

	/*	
		confirm.addActionListener(this) 
		public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle confirmed order
				//Think about where you will store order and who should manipulate.
				//Handle the Payment validation before confirming order. Who should validate?
				text.setText("Order confrimed for ");
				};*/
		JButton cancel = new JButton("Cancel Order");
		/*cancel.addActionListener(this) 
				public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle cancel order
				//Think about where you will store order and who should manipulate.
				text.setText("Order cancelled");
				};

*/
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);

		//Buttons WEST
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4,4,4));
		buttonPanel.setPreferredSize(new Dimension(600, 600));
		// TODO: Ask the presenter for the buttons to create. Iterate over the buttons and create them
		for(MenuModel m: presenter.getModel()){
			buttonPanel.add(new JButton(m.getName()));
		}
		theFrame.add(title, BorderLayout.NORTH);
		theFrame.add(displayPanel, BorderLayout.CENTER);
		theFrame.add(buttonPanel, BorderLayout.WEST);
		theFrame.add(orderPane, BorderLayout.EAST);
		theFrame.setPreferredSize(new Dimension(1100,800));

		theFrame.pack();
		theFrame.setVisible(true);

	}
}
