package utils;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import javax.swing.event.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public abstract class SuggestionUtility extends JTextField {
	private static final long serialVersionUID = 1L;
	private JPopupMenu popupMenu;
    private JList<String> listComp;
    DefaultListModel<String> listModel;
    private boolean disableTextEvent = false;

    public boolean isDisableTextEvent() {
        return disableTextEvent;
    }

    public void setDisableTextEvent(boolean disableTextEvent) {
        this.disableTextEvent = disableTextEvent;
    }


    public SuggestionUtility(boolean isDisableTextEvent) {
        super();
        this.disableTextEvent = isDisableTextEvent;
        init();
    }

    public SuggestionUtility(String text) {
        super(text);
        init();
    }


    public SuggestionUtility(int columns) {
        super(columns);
        init();
    }

    public SuggestionUtility(String text, int columns) {
        super(text, columns);
        init();
    }

    public SuggestionUtility(Document doc, String text, int columns) {
        super(doc, text, columns);
        init();
    }

    public void init() {
        initPopup();
        initSuggestionCompListener();
        initInvokerKeyListeners();
    }

    private void initPopup() {
        popupMenu = new JPopupMenu();
        listModel = new DefaultListModel<String>();
        listComp = new JList<String>(listModel);
        listComp.setFont(new Font("Tohama", 0, 15));
        listComp.setBounds(0, 0, 500, 500);
        listComp.setBorder(BorderFactory.createEmptyBorder(0, 2, 5, 2));
        listComp.setFocusable(false);
        popupMenu.setFocusable(false);
        popupMenu.add(listComp);  
    }

    private void initSuggestionCompListener() {
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update(e);
            }

            private void update(DocumentEvent e) {
                if (disableTextEvent) {
                    return;
                }
                SwingUtilities.invokeLater(() -> {
                    List<String> suggestions = null;
                    try {
                        suggestions = getSuggestions(e.getDocument().getText(0, e.getDocument().getLength()));
                    } catch (BadLocationException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (suggestions != null && !suggestions.isEmpty()) {
                        showPopup(suggestions);
                    } else {
                        popupMenu.setVisible(false);
                    }
                });
            }
        });
    }


    private void showPopup(List<String> suggestions) {
        listModel.clear();
        suggestions.forEach(listModel::addElement);
        Point p = new Point(0, this.getPreferredSize().height);
        if (p != null) {
        	popupMenu.pack();
            listComp.setSelectedIndex(0);
            popupMenu.show(this, (int) p.getX(), (int) p.getY());
        }
    }

    private void initInvokerKeyListeners() {
        //not using key inputMap cause that would override the original handling
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER) {
                    selectFromList(e);
                } else if (e.getKeyCode() == VK_UP) {
                    moveUp(e);
                } else if (e.getKeyCode() == VK_DOWN) {
                    moveDown(e);
                } else if (e.getKeyCode() == VK_ESCAPE) {
                    popupMenu.setVisible(false);
                }
            }
        });
    }

    private void selectFromList(KeyEvent e) {
        if (popupMenu.isVisible()) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex != -1) {
                popupMenu.setVisible(false);
                String selectedValue = listComp.getSelectedValue();
                disableTextEvent = true;
                this.setText(selectedValue);
                disableTextEvent = false;
                e.consume();
            }
        }
    }

    private void moveDown(KeyEvent keyEvent) {
        if (popupMenu.isVisible() && listModel.getSize() > 0) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex < listModel.getSize()) {
                listComp.setSelectedIndex(selectedIndex + 1);
                keyEvent.consume();
            }
        }
    }

    private void moveUp(KeyEvent keyEvent) {
        if (popupMenu.isVisible() && listModel.getSize() > 0) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex > 0) {
                listComp.setSelectedIndex(selectedIndex - 1);
                keyEvent.consume();
            }
        }
    }

    public abstract List<String> getSuggestions(String textContent);
}
