/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coursework;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File; //gives access permission
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KabiRubekSanamSanish
 */
public class MenuInfo implements ActionListener {

    private JFrame frame;
    private static final int FRAME_WIDTH = 1035; //why static? memory efficient, only 1 copy
    private JFrame about;

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu helpMenu;

    private JMenuItem openMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem helpMenuItem;
    private JMenuItem aboutMenuItem;

    private JPanel addItemsPanel;
    private JPanel genderPanel;
    private JPanel mainPanel;
    private JPanel tablePanel;

    private JLabel mainTitle;
    private JLabel addItemsSectionTitle;
    private JLabel productNameLabel;
    private JLabel categoryLabel;
    private JLabel gender;
    private JLabel sizeLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JLabel searchPriceLabel;
    private JLabel aboutInfo;

    private JTextField productName;
    private JTextField quantity;
    private JTextField price;
    private JTextField searchTF;

    private JComboBox category;
    private JComboBox size;
    private JComboBox categories;
    private static final String[] CATEGORIES = {"Tops", "Bottoms", "Shoes", "Accessories", "Innerwear"};
    private static final String[] SIZES = {"XS", "S", "M", "L", "XL"};

    private JRadioButton men;
    private JRadioButton women;
    private JRadioButton both;
    private ButtonGroup genderGroup;

    private JButton increaseQty;
    private JButton decreaseQty;
    private JButton add;
    private JButton update;
    private JButton clear;
    private JButton search;
    private JButton clearTable;
    private JButton delete;
    private JButton viewAvailableItems;

    private JTable table;
    //headers for table
    private static final String[] COLUMNS = {"ProductId", "Name", "Category", "Group", "Size", "Quantity", "Price"};
    //actual data for table in 2d array
    private final Object[][] data = {
        {1, "Hoodie", "Tops", "Both", "M", 10, 5000},
        {2, "T-shirt", "Tops", "Women", "XL", 3, 200},
        {3, "Belt", "Accessories", "Men", "M", 10, 5000},
        {4, "Scarf", "Accessories", "Women", "S", 5, 1000},
        {5, "Half-pant", "Bottoms", "Men", "XS", 1, 500},
        {6, "Leather shoes", "Shoes", "Men", "M", 2, 500},
        {7, "High heeled stencils", "Shoes", "Women", "L", 3, 200},
        {8, "Jeans-pant", "Bottoms", "Women", "M", 10, 5000},
        {9, "Skirt", "Bottoms", "Women", "S", 5, 1000},
        {10, "Tie", "Accessories", "Men", "XS", 1, 1500},
        {11, "Plain T-Shirt", "Tops", "Men", "M", 2, 500},
        {12, "Sports-shoes", "Shoes", "Men", "M", 10, 5000},
        {13, "Boxer", "Innerwear", "Men", "XL", 5, 1000},
        {14, "Bra", "Innerwear", "Women", "S", 1, 1500},
        {15, "Sunglasses", "Accessories", "Both", "M", 2, 500}};

    private int productID = 16;

    private final ArrayList<Items> list;

    private DefaultTableModel tableModel;

    private JScrollPane scrollPane;

    public MenuInfo() {
        GUI();
        list = new ArrayList<>();
        for (Object[] a : data) {
            addRec(a);
        }
    }

    private void addRec(Object[] data) {
        tableModel.addRow(data);
        list.add(new Items(data));
    }

    //private so that this method cannot be overriden, a convention which helps avoid errors if subclass is involved
    private void GUI() {
        //initialising the frame
        frame = new JFrame("Silhouette Clothing Store System");
        frame.setLayout(null);

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, FRAME_WIDTH, 30);
        frame.add(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
        openMenuItem.addActionListener(this);

        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenuItemActionPerformed();
            }
        });

        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        helpMenuItem = new JMenuItem("Help Content");
        helpMenu.add(helpMenuItem);
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpMenuItemActionPerformed();
            }
        });

        aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutMenuItemActionPerformed();
            }
        });

        mainTitle = new JLabel("Silhouette Clothing Store");
        mainTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        mainTitle.setBounds(380, 40, 300, 30);
        frame.add(mainTitle);

        //panel for data entry of new items
        addItemsPanel = new JPanel();
        addItemsPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        addItemsPanel.setLayout(null);
        addItemsPanel.setBounds(20, 80, 340, 480);
        frame.add(addItemsPanel);

        addItemsSectionTitle = new JLabel("Add Items");
        addItemsSectionTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        addItemsSectionTitle.setBounds(120, 10, 100, 30);
        addItemsPanel.add(addItemsSectionTitle);

        productNameLabel = new JLabel("Product Name:");
        productNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        productNameLabel.setBounds(20, 70, 130, 30);
        addItemsPanel.add(productNameLabel);

        productName = new JTextField();
        productName.setBounds(130, 70, 190, 30);
        addItemsPanel.add(productName);

        categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        categoryLabel.setBounds(20, 120, 130, 30);
        addItemsPanel.add(categoryLabel);

        category = new JComboBox(CATEGORIES);
        category.setBounds(130, 120, 100, 30);
        addItemsPanel.add(category);

        gender = new JLabel("Group:");
        gender.setFont(new Font("Dialog", Font.BOLD, 14));
        gender.setBounds(20, 170, 130, 30);
        addItemsPanel.add(gender);

        genderPanel = new JPanel();
        genderPanel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));
        genderPanel.setLayout(null);
        genderPanel.setBounds(20, 200, 300, 50);
        addItemsPanel.add(genderPanel);

        men = new JRadioButton("Men");
        men.setFont(new Font("Dialog", Font.BOLD, 14));
        men.setActionCommand("Men");
        men.setBounds(30, 10, 80, 30);
        genderPanel.add(men);

        women = new JRadioButton("Women");
        women.setFont(new Font("Dialog", Font.BOLD, 14));
        women.setActionCommand("Women");
        women.setBounds(110, 10, 80, 30);
        genderPanel.add(women);

        both = new JRadioButton("Both");
        both.setFont(new Font("Dialog", Font.BOLD, 14));
        both.setActionCommand("Both");
        both.setBounds(210, 10, 80, 30);
        genderPanel.add(both);

        genderGroup = new ButtonGroup();
        genderGroup.add(men);
        genderGroup.add(women);
        genderGroup.add(both);

        sizeLabel = new JLabel("Size:");
        sizeLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        sizeLabel.setBounds(20, 260, 130, 30);
        addItemsPanel.add(sizeLabel);

        size = new JComboBox(SIZES);
        size.setBounds(130, 260, 100, 30);
        addItemsPanel.add(size);

        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        quantityLabel.setBounds(20, 310, 130, 30);
        addItemsPanel.add(quantityLabel);

        decreaseQty = new JButton("-");
        decreaseQty.setFont(new Font("Dialog", Font.PLAIN, 24));
        decreaseQty.setBorder(null);
        decreaseQty.setBackground(Color.red);
        decreaseQty.setForeground(Color.WHITE);
        decreaseQty.setBounds(130, 310, 30, 30);
        decreaseQty.addActionListener(this);
        addItemsPanel.add(decreaseQty);

        quantity = new JTextField("1");
        quantity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
        quantity.setHorizontalAlignment(JTextField.CENTER);
        quantity.setBounds(160, 310, 50, 30);
        addItemsPanel.add(quantity);

        increaseQty = new JButton("+");
        increaseQty.setFont(new Font("Dialog", Font.PLAIN, 18));
        increaseQty.setBorder(null);
        increaseQty.setBackground(Color.GREEN);
        increaseQty.setForeground(Color.WHITE);
        increaseQty.setBounds(210, 310, 30, 30);
        increaseQty.addActionListener(this);
        addItemsPanel.add(increaseQty);

        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        priceLabel.setBounds(20, 360, 130, 30);
        addItemsPanel.add(priceLabel);

        price = new JTextField();
        price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
        price.setBounds(130, 360, 100, 30);
        addItemsPanel.add(price);

        add = new JButton("Add");
        add.addActionListener(this);
        add.setBounds(30, 430, 80, 30);
        addItemsPanel.add(add);

        update = new JButton("Update");
        update.addActionListener(this);
        update.setBounds(130, 430, 80, 30);
        addItemsPanel.add(update);

        clear = new JButton("Clear");
        clear.setBounds(230, 430, 80, 30);
        clear.addActionListener(this);
        addItemsPanel.add(clear);

        //this panel will contain the search, table of records and view available item query
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        //int value indicates the thickness of the border.
        //true for rounded corner border and false for non-rounded border.
        mainPanel.setLayout(null);
        //null layout helps to set the component manually using setBounds() method.
        mainPanel.setBounds(380, 80, 630, 480);
        frame.add(mainPanel);

        searchPriceLabel = new JLabel("Price:");
        searchPriceLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        searchPriceLabel.setBounds(350, 20, 130, 30);
        mainPanel.add(searchPriceLabel);

        searchTF = new JTextField();
        searchTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
        searchTF.setBounds(400, 20, 100, 30);
        mainPanel.add(searchTF);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(520, 20, 80, 30);
        mainPanel.add(search);

        //panel to accomodate table
        tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 2, true),
                "Menu Details", 0, 0, new Font("Dialog", Font.BOLD, 20), Color.DARK_GRAY));
        tablePanel.setLayout(null);
        tablePanel.setBounds(20, 50, 590, 340);
        mainPanel.add(tablePanel);

        tableModel = new DefaultTableModel(null, COLUMNS);

        table = new JTable(tableModel);
        table.setBounds(10, 10, 560, 310);
        //Allowing only one row to be selected at a time.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    productName.setText(table.getValueAt(selectedRow, 1).toString());
                    category.setSelectedItem(table.getValueAt(selectedRow, 2));
                    String radioButton = String.valueOf(table.getValueAt(selectedRow, 3));
                    switch (radioButton) {
                        case "Men":
                            genderGroup.setSelected(men.getModel(), true);
                            break;
                        case "Women":
                            genderGroup.setSelected(women.getModel(), true);
                            break;
                        default:
                            genderGroup.setSelected(both.getModel(), true);
                            break;
                    }
                    size.setSelectedItem(table.getValueAt(selectedRow, 4));
                    quantity.setText(table.getValueAt(selectedRow, 5).toString());
                    price.setText(table.getValueAt(selectedRow, 6).toString());
                }
            }
        });

        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); //To use the entire height of the container even if table doesn't have enough rows.
        scrollPane.setBounds(10, 25, 570, 305);
        tablePanel.add(scrollPane);

        clearTable = new JButton("Clear Table");
        clearTable.addActionListener(this);
        clearTable.setBounds(40, 430, 100, 30);
        mainPanel.add(clearTable);

        delete = new JButton("Delete");
        delete.setBounds(160, 430, 100, 30);
        delete.addActionListener(this);
        mainPanel.add(delete);

        categories = new JComboBox(CATEGORIES);
        categories.setBounds(330, 430, 100, 30);
        mainPanel.add(categories);

        viewAvailableItems = new JButton("View Available Items");
        viewAvailableItems.setBounds(450, 430, 160, 30);
        viewAvailableItems.addActionListener(this);
        mainPanel.add(viewAvailableItems);

        frame.setSize(FRAME_WIDTH, 610);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void openMenuItemActionPerformed() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("resources\\Islington.jpg"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "File not found. May be file was renamed, changed or deleted");
        }
    }

    private void exitMenuItemActionPerformed() {
        System.exit(0);
    }

    private void helpMenuItemActionPerformed() {
        try {
            if (Desktop.isDesktopSupported()) {
                // .docx can be made read-only so that help content won't change.

                Desktop.getDesktop().open(new File("Resources\\help.docx"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "File not found. May be file was renamed, changed or deleted");
        }
    }

    private void aboutMenuItemActionPerformed() {
        about = new JFrame("About");

        aboutInfo = new JLabel();
        aboutInfo.setIcon(new ImageIcon("resources\\about.PNG"));
        about.add(aboutInfo);

        about.setResizable(false);
        about.pack();
        about.setLocationRelativeTo(frame);
        about.setVisible(true);
    }

    public String increaseValue(String value) {
        //handling empty value in quantity textfield
        if (value.equals("")) {
            value = "0";
        }
        int i = Integer.parseInt(value);
        i++;
        return String.valueOf(i);
    }

    public String decreaseValue(String value) {
        //handling empty value in quantity textfield
        if (value.equals("")) {
            value = "2";
        }
        //to not allow quantity to be less than -1
        if (value.equals("1")) {
            return "1";
        }
        int i = Integer.parseInt(value);
        i--;
        return String.valueOf(i);
    }

    public void add() {
        if (productName.getText().equals("")) {
            JOptionPane.showMessageDialog(addItemsPanel, "Enter product name.",
                    "Product name missing", JOptionPane.ERROR_MESSAGE);
        } else if (category.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(addItemsPanel, "Select a category.",
                    "Category not selected", JOptionPane.ERROR_MESSAGE);
        } else if (genderGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(addItemsPanel, "Choose a group.",
                    "Group missing", JOptionPane.ERROR_MESSAGE);
        } else if (size.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(addItemsPanel, "Select a size.",
                    "Size not selected", JOptionPane.ERROR_MESSAGE);
        } else if (quantity.getText().equals("")) {
            JOptionPane.showMessageDialog(addItemsPanel, "Enter quantity.",
                    "Quantity missing!", JOptionPane.ERROR_MESSAGE);
        } else if (price.getText().equals("")) {
            JOptionPane.showMessageDialog(addItemsPanel, "Enter price.",
                    "Price missing!", JOptionPane.ERROR_MESSAGE);
        } else { //checking duplication and then adding
            String inputValue = productName.getText()
                    + genderGroup.getSelection().getActionCommand()
                    + (String) size.getSelectedItem()
                    + price.getText();
            String existingValue;
            boolean found = true;
            for (int i = 0; i < table.getRowCount(); i++) {
                existingValue = (String) table.getValueAt(i, 1) + table.getValueAt(i, 3) + table.getValueAt(i, 4) + table.getValueAt(i, 6);
                if (existingValue.equalsIgnoreCase(inputValue)) {
                    JOptionPane.showMessageDialog(addItemsPanel, "Same value", "Please try updating instead!", JOptionPane.INFORMATION_MESSAGE);
                    found = false;
                    break;
                }
            }
            if (found) {
                Object[] newItem = {
                    productID,
                    productName.getText(),
                    (String) category.getSelectedItem(),
                    genderGroup.getSelection().getActionCommand(),
                    (String) size.getSelectedItem(),
                    Integer.parseInt(quantity.getText()),
                    Integer.parseInt(price.getText())
                };
                //incrementing product id for next item
                productID++;
                addRec(newItem);
            }
        }
    }

    public void update() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(addItemsPanel, "No record has been selected for update",
                    "Select a row", JOptionPane.ERROR_MESSAGE);
        } else {
            //getting new updated values
            int id = (Integer) table.getValueAt(selectedRow, 0);
            String newProductName = productName.getText();
            String newCategory = String.valueOf(category.getSelectedItem());
            String newGroup = genderGroup.getSelection().getActionCommand();
            String newSize = String.valueOf(size.getSelectedItem());
            int newQuantity = Integer.parseInt(quantity.getText());
            int newPrice = Integer.parseInt(price.getText());

            //updating the table
            table.setValueAt(newProductName, selectedRow, 1);
            table.setValueAt(newCategory, selectedRow, 2);
            table.setValueAt(newGroup, selectedRow, 3);
            table.setValueAt(newSize, selectedRow, 4);
            table.setValueAt(newQuantity, selectedRow, 5);
            table.setValueAt(newPrice, selectedRow, 6);

            //updating the arraylist
            Object[] newData = {id, newProductName, newCategory, newGroup, newSize, newQuantity, newPrice};
            list.set(selectedRow, new Items(newData));

            JOptionPane.showMessageDialog(frame, "Successfully updated", "Updated", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //method to empty the textfield.

    public void clear() {
        productName.setText("");
        category.setSelectedIndex(0);
        genderGroup.clearSelection();
        size.setSelectedIndex(0);
        quantity.setText("1");
        price.setText("");
        //handles the error which occurs if user first selects an item from table, clears data and updates.
        table.getSelectionModel().clearSelection();
    }

    public void search() {
        MergeSort.mergeSort(list);
        String searchPrice = searchTF.getText();
        if (searchPrice.equals("")) {
            JOptionPane.showMessageDialog(mainPanel, "Please enter price to search.",
                    "Price missing", JOptionPane.ERROR_MESSAGE);
        } else {
            int searchKey = Integer.parseInt(searchPrice);
            Items item = binarySearch(list, 0, list.size() - 1, searchKey);
            if (item == null) {
                JOptionPane.showMessageDialog(mainPanel, "There are no items matching the price you entered.",
                        "Price not found", JOptionPane.ERROR_MESSAGE);
            } else {
                String name = item.getName() + " ";
                String category = item.getCategory() + " ";
                String group = item.getGroup() + " ";
                String quantity = item.getQuantity() + " ";
                String size = item.getSize() + " ";
                JOptionPane.showMessageDialog(mainPanel, name + category + group + size + quantity,
                        "Price matched!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static Items binarySearch(ArrayList<Items> list, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getPrice() == value) {
                return list.get(mid);
            } else if (list.get(mid).getPrice() < value) {
                return binarySearch(list, mid + 1, high, value);
            } else {
                return binarySearch(list, low, mid - 1, value);
            }
        } else {
            return null;
        }
    }

    public void clearTable() {
        int decision = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to delete all the records?",
                "Clear all records confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (decision == JOptionPane.YES_OPTION) {
            //clearing the table
            tableModel.setRowCount(0);
            //emptying the arraylist
            list.clear();
        }
    }

    public void delete() {
        //making sure a row is selected
        //if row is not selected then getSelectedRow() returns int value -1.
        if (table.getSelectedRow() != -1) {
            int decision = JOptionPane.showConfirmDialog(tablePanel, "Are you sure you want to delete",
                    "Delete confiramtion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (decision == JOptionPane.YES_OPTION) {
                int productID = (Integer) table.getValueAt(table.getSelectedRow(), 0);
                int index = 0;
                for (Items i : list) {
                    if (i.getProductId() == productID) {
                        index = list.indexOf(i);
                        break;
                    }
                }
                list.remove(index);
                tableModel.removeRow(table.getSelectedRow());
            }
            clear();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Select a record first!",
                    "No record selected", JOptionPane.ERROR_MESSAGE);
        }
    }

    //this method counts the number of items in a specific category
    public String viewAvailableItems() {
        String result;
        int count = 0;
        String searchValue = (String) categories.getSelectedItem();
        String listOfItems = "";
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = (String) table.getValueAt(i, 2);//category column
            if (searchValue.equals(value)) {
                String nameOfItemFound = String.valueOf(table.getValueAt(i, 1));
                String groupOfItemFound = String.valueOf(table.getValueAt(i, 3));
                String sizeOfItemFound = String.valueOf(table.getValueAt(i, 4));
                String priceOfItemFound = String.valueOf(table.getValueAt(i, 6));
                count++;
                listOfItems += String.valueOf(count) + ". "//serial numbering
                        + nameOfItemFound + " for " + groupOfItemFound + " "
                        + sizeOfItemFound + " size costing " + priceOfItemFound + "\n";
            }
        }
        result = "There are " + count + " " + searchValue + ":\n" + listOfItems;
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            add();
        } else if (e.getSource() == update) {
            update();
        } else if (e.getSource() == clear) {
            clear();
        } else if (e.getSource() == increaseQty) {
            quantity.setText(increaseValue(quantity.getText()));
        } else if (e.getSource() == decreaseQty) {
            quantity.setText(decreaseValue(quantity.getText()));
        } else if (e.getSource() == search) {
            search();
        } else if (e.getSource() == clearTable) {
            clearTable();
        } else if (e.getSource() == delete) {
            delete();
        } else if (e.getSource() == viewAvailableItems) {
            JOptionPane.showMessageDialog(frame, viewAvailableItems(), "Number of Items", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == openMenuItem){
            openMenuItemActionPerformed();
        }
    }

    //consumes text if not a digit
    public void jTextFieldKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
    
    public static void main(String[] args) {
        new MenuInfo();
    }
}
